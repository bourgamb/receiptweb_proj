create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table currency (id bigint not null auto_increment, currency varchar(255), primary key (id)) engine=InnoDB;
create table notes (id bigint not null auto_increment, receipt_notes longtext, primary key (id)) engine=InnoDB;
create table receipt (id bigint not null auto_increment, approval varchar(255), currency varchar(255), description varchar(255), image longblob, total_amount decimal(19,2), type varchar(255), url varchar(255), notes_id bigint, primary key (id)) engine=InnoDB;
create table receipt_category (receipt_id bigint not null, category_id bigint not null, primary key (receipt_id, category_id)) engine=InnoDB;
create table receipt_entry (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), quantity integer, currency_id bigint, receipt_id bigint, primary key (id)) engine=InnoDB;
alter table receipt add constraint FK93coj8uqp37xb3r1rxpm2n6d9 foreign key (notes_id) references notes (id);
alter table receipt_category add constraint FKk2l636ukwr81idqu9b1trcgj5 foreign key (category_id) references category (id);
alter table receipt_category add constraint FKctxe5qmqq6wlenxercwv8nnec foreign key (receipt_id) references receipt (id);
alter table receipt_entry add constraint FKnggmbtjrwigx29oj3l8v2tygp foreign key (currency_id) references currency (id);
alter table receipt_entry add constraint FKloq2r1uvhvslbne6ajyfg33il foreign key (receipt_id) references receipt (id);