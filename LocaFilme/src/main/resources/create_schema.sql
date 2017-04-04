CREATE TABLE filme (
  id SERIAL,
  nome VARCHAR(255),
  genero int(11),
  duracao int(11),
  status int(11),
  dtempreste date,
  dtdevolve date
)
