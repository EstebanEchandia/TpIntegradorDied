CREATE SCHEMA trabajoPractico

	CREATE TABLE trabajoPractico.planta
	
			(
			id SERIAL,
			nombre varchar(100),

			CONSTRAINT pk_idPlanta PRIMARY KEY (id)
		);
		
	CREATE TABLE trabajoPractico.camion
		(	
			
			id SERIAL,
			
			patente varchar(20) UNIQUE,
			modelo varchar(100),
			kmRecorridos numeic(20,2),
			costoPorKm numeric(20,2),
			costoPorHora numeric(20,2),
			fechaDeCompra date NOT NULL,
			idPlanta integer ,

			CONSTRAINT pk_idCamion PRIMARY KEY (id),
			
			CONSTRAINT fk_idPlanta FOREIGN KEY (idPlanta)
			REFERENCES trabajoPractico.planta(id)

		);



	CREATE TABLE trabajoPractico.envio
			(
			id SERIAL,
			costo numeric(20,2) NOT NULL,
			idCamion integer NOT NULL,

			CONSTRAINT pk_idEnvio PRIMARY KEY (id),
			CONSTRAINT fk_idCamion FOREIGN KEY (idCamion)
			REFERENCES trabajoPractico.camion(id)
		);
	
	CREATE TYPE estados AS
	ENUM('CREADA','PROCESADA','ENTREGADA','CANCELADO');

	CREATE TABLE trabajoPractico.pedido
			(
			numeroDeOrden SERIAL,
			fechaSolicitud date,
			fechaEntrega date,
			estado estados NOT NULL,
			idEnvio integer,
			plantaOrigen integer,
			plantaDestino integer,
			

			CONSTRAINT pk_nroOrden PRIMARY KEY (numeroDeOrden),

			CONSTRAINT fk_idEnvio FOREIGN KEY (idEnvio)
			REFERENCES trabajoPractico.envio(id),

			CONSTRAINT fk_plantaOrigen FOREIGN KEY (plantaOrigen)
			REFERENCES trabajoPractico.planta(id),

			CONSTRAINT fk_plantaDestino FOREIGN KEY (plantaDestino)
			REFERENCES trabajoPractico.planta(id)


		);
		
			CREATE TYPE unidad AS
	ENUM('KILO','PIEZA','GRAMO','METRO','LITRO','M3','M2');

	CREATE TABLE trabajoPractico.insumo
	(

			id SERIAL,
			descripcion varchar(100),
			unidadDeMedida unidad NOT NULL,
			costo numeric(20,2) NOT NULL,

			CONSTRAINT pk_idInsumo PRIMARY KEY (id)
		);
		
		
	CREATE TABLE trabajoPractico.itempedido
			(
			id SERIAL,
			cantidad numeric(20,2),
			numeroDeOrden integer,
			idInsumo integer,

			CONSTRAINT pk_idItemPedido PRIMARY KEY (id),

			CONSTRAINT fk_numeroDeOrden FOREIGN KEY (numeroDeOrden)
			REFERENCES trabajoPractico.pedido(numeroDeOrden),

			CONSTRAINT fk_idInsumo FOREIGN KEY (idInsumo)
			REFERENCES trabajoPractico.insumo(id)

		);



	CREATE TABLE trabajoPractico.insumoLiquido
		(
			id integer,
			densidad numeric(20,2) NOT NULL,

			CONSTRAINT pk_idInsumoLiquido PRIMARY KEY (id),

			CONSTRAINT fk_id FOREIGN KEY (id)
			REFERENCES trabajoPractico.insumo(id)
		);

	CREATE TABLE trabajoPractico.insumoGeneral
		(
			id integer,
			peso numeric(20,2) NOT NULL,

			CONSTRAINT pk_idInsumoGeneral PRIMARY KEY (id),

			CONSTRAINT fk_id FOREIGN KEY (id)
			REFERENCES trabajoPractico.insumo(id)
		);

	
	

	CREATE TABLE trabajoPractico.stock
		(
			id SERIAL,
			cantidad numeric(20,2),
			ptoMinimoDePedido numeric(20,2) ,
			idInsumo integer,
			idPlanta integer,

			CONSTRAINT pk_idStock PRIMARY KEY (id),

			CONSTRAINT fk_idInsumo FOREIGN KEY (idInsumo)
			REFERENCES trabajoPractico.insumo(id),

			CONSTRAINT fk_idPlanta FOREIGN KEY (idPlanta)
			REFERENCES trabajoPractico.planta(id)
		);

		CREATE TABLE trabajoPractico.ruta
		(
			sigla varchar(10),
			distanciaEnKm numeric(20,2),
			duracionEnM numeric(20,2) ,
			cantMaxATransportarEnKg numeric(20,2) ,
			plantaOrigen integer,
			plantaDestino integer,

			CONSTRAINT pk_idStock PRIMARY KEY (sigla),

			CONSTRAINT fk_plantaOrigenRuta FOREIGN KEY (plantaOrigen)
			REFERENCES trabajoPractico.planta(id),

			CONSTRAINT fk_plantaDestinoRuta FOREIGN KEY (plantaDestino)
			REFERENCES trabajoPractico.planta(id)
			)
	
	