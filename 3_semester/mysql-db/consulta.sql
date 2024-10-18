CREATE VIEW ContasNaoPagas AS
SELECT
    ContaReceber.ID AS ContaReceberID,
    Cliente.Nome AS NomeCliente,
    Cliente.CPF AS CPFCliente,
    ContaReceber.DataVencimento,
    ContaReceber.Valor
FROM
    ContaReceber
INNER JOIN
    Cliente ON ContaReceber.Cliente_ID = Cliente.ID
WHERE
    ContaReceber.Situacao = '1';

SELECT * FROM ContasNaoPagas;