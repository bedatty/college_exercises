INSERT INTO Estado (Nome, UF) VALUES
('São Paulo', 'SP'),
('Rio de Janeiro', 'RJ'),
('Minas Gerais', 'MG');

INSERT INTO Municipio (Nome, CodIBGE, Estado_ID) VALUES
('São Paulo', 3550308, 1),
('Rio de Janeiro', 3304557, 2),
('Belo Horizonte', 3106200, 3);

INSERT INTO Cliente (Nome, CPF, Celular, EndLogradouro, EndNumero, EndMunicipio, EndCEP, Municipio_ID) VALUES
('João Silva', '12345678901', '11999999999', 'Rua A', '100', 3550308, '01001000', 1),
('Maria Oliveira', '98765432100', '21988888888', 'Av B', '200', 3304557, '20040002', 2),
('Carlos Souza', '45678912302', '31977777777', 'Rua C', '300', 3106200, '30110010', 3);

INSERT INTO ContaReceber (Cliente_ID, FaturaVendaID, DataConta, DataVencimento, Valor, Situacao) VALUES
(1, 1001, '2024-01-01', '2024-02-01', 500.00, '1'),
(2, 1002, '2024-01-10', '2024-02-10', 750.50, '2'),
(3, 1003, '2024-01-15', '2024-02-15', 1250.75, '3');