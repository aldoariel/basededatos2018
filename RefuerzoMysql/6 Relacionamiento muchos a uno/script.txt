alter table pedido
  add column cliente_id bigint,
  add constraint fk_cliente_id
    foreign key (cliente_id)
      references cliente(id)

