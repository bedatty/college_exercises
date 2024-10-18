CREATE DATABASE loja;
USE loja;

CREATE TABLE Estado (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50) NOT NULL,
    UF CHAR(2) NOT NULL
);

CREATE TABLE Municipio (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(80) NOT NULL,
    CodIBGE INT,
    Estado_ID INT,
    CONSTRAINT fk_Municipio_Estado1_idx FOREIGN KEY (Estado_ID) REFERENCES Estado(ID)
);

CREATE TABLE Cliente (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(80) NOT NULL,
    CPF CHAR(11) NOT NULL,
    Celular CHAR(11),
    EndLogradouro VARCHAR(100),
    EndNumero VARCHAR(10),
    EndMunicipio INT,
    EndCEP CHAR(8),
    Municipio_ID INT,
    CONSTRAINT fk_Cliente_Municipio1_idx FOREIGN KEY (Municipio_ID) REFERENCES Municipio(ID)
);

CREATE TABLE ContaReceber (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Cliente_ID INT,
    FaturaVendaID INT,
    DataConta DATE,
    DataVencimento DATE,
    Valor DECIMAL(18,2),
    Situacao ENUM('1', '2', '3') NOT NULL,
    CONSTRAINT fk_ContaReceber_Cliente_idx FOREIGN KEY (Cliente_ID) REFERENCES Cliente(ID)
);
