# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table koma (
  id                        bigint not null,
  name                      varchar(255),
  day                       varchar(255),
  num                       varchar(255),
  prof                      varchar(255),
  constraint pk_koma primary key (id))
;

create sequence koma_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists koma;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists koma_seq;

