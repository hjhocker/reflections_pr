create table event_components (
  id bigserial primary key,
  event_id varchar not null,
  is_planning boolean default false,
  esn varchar,

  -- The combination of Event ID, ESN and Is Planning is unique
  -- This allows for a Charlie and Alpha component to be added
  -- to the same event but both reference the same ESN
  constraint unique_eventId_esn_isPlanning_constraint
    unique (event_id, esn, is_planning)
);

--Used to create Event IDs when creating new events
create sequence event_id_sequence start 1;

create table event_unit_sources (
  id bigserial primary key,
  source_name varchar CHECK (upper(source_name) = source_name), -- only uppercase allowed
  source_id varchar,
  event_component_id bigint not null references event_components(id),

  -- Source ID, Source Name and Event Component ID must be unique
  -- This prevents one event_unit_source from being mapped to
  -- multiple events
  constraint unique_sourceName_sourceId_eventComponentId_constraint
    unique (source_id, source_name, event_component_id),

  -- Source ID and Source Name can only be entered once so only 1 copy of each
  constraint unique_sourceName_sourceId_constraint
    unique (source_id, source_name)
);

-- Only allow for Alpha and Charlie components of events
ALTER TABLE event_unit_sources
   ADD CONSTRAINT sourceName_is_charlie_or_alpha_constraint
   CHECK (source_name IN ('ALPHA', 'CHARLIE'));

-- Only allow 1 Alpha component per Event. The
-- unique_eventId_esn_isPlanning_constraint constraint
-- from just adding tons of Alpha components to an event
CREATE OR REPLACE FUNCTION fv_only_one_alpha_component_per_event(eci bigint, sn varchar)
  returns boolean as
$$
BEGIN
  IF sn = 'CHARLIE' THEN
    RETURN TRUE;
  END IF;
  RETURN (select count(ec.event_id) = 0 from event_components ec
    join event_unit_sources eus on eus.event_component_id = ec.id
    where ec.event_id = (select event_id from event_components where id = eci)
    and eus.source_name = 'ALPHA');
END;
$$
LANGUAGE 'plpgsql';

alter table event_unit_sources
  add constraint fv_only_one_alpha_component_per_event_constraint
  CHECK (fv_only_one_alpha_component_per_event(event_component_id, source_name));
