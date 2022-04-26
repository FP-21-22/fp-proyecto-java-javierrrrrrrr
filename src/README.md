# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2021/2022)
Autor/a: Javier Nieto Vicioso  uvus:javnievic@us.es

Aquí debes añadir la descripción del dataset y un enunciado del dominio del proyecto.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.\<clinico\>**: Paquete que contiene los tipos del proyecto.
  * **fp.\<clinico\>.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **\<dataset1.csv\>**: Añade una descripción genérica del dataset.
    * **\<dataset2.csv\>**: Añade una descripción del resto de datasets que puedas tener.
    
## Estructura del *dataset*

Aquí debes describir la estructura del dataset explicando qué representan los datos que contiene y la descripción de cada una de las columnas. Incluye también la URL del dataset original.

El dataset está compuesto por \<N\> columnas, con la siguiente descripción:

* **\<columna 1>**: de tipo \<tipo\>, representa....
* **\<columna 2>**: de tipo \<tipo\>, representa....


## Tipos implementados

Describe aquí los tipos que usas en tu proyecto.

### Tipo Persona
Descripción breve del tipo base.

**Propiedades**:

- _nombre_, de tipo String, consultable. 
- _apellidos_, de tipo String, consultable. 
- dni, de tipo String, consultable. 
- fechaNacimiento, de tipo LocalDate, consultable . 



**Restricciones**:
 
- R1: La fecha de nacimiento debe ser anterior a la fecha de hoy.
- R2: El dni debe ser una cadena con ocho dígitos y seguidos de una letra.

**Criterio de igualdad**: Asociado por defecto al Record.

**Criterio de ordenación**:Se ordena por dni.

**Propiedades Derivadas**:
- edad, de tipo Integer, consultable,derivada, a partir de la fecha de nacimiento. 
- 
**Otras operaciones**:
 
-	_dniValido_: Devuelve un tipo Boolean que es cierto si el dni tiene nueve caracteres,de ellos,
8 son dígitos y el restante una letra, y falso si no cumple alguna de estas condiciones.	


### Factoría
Descripción breve de la factoría.

- _método static of_: recibe nombre, apellidos, dni y fecha de nacimiento y devuelve un objeto persona.
-	_método static parse_: Recibe una cadena con un formato específico y devuelve un objeto  persona.



### Tipo Paciente


**Propiedades**:

- _persona_, de tipo Persona, consultable. 
- _codigoIngreso_, de tipo String, consultable.
- _fechaHoraIngreso_, de tipo LocalDateTime, consultable. 


**Restricciones**:
 
- R1: La fecha y hora de ingreso debe ser anterior o igual a la fecha de hoy.

**Representación como cadena**: por defecto asociado al record.

**Criterio de igualdad**: Asociado por defecto al Record.

**Criterio de ordenación**: No hay criterio de ordenación.

**Propiedades derivadas**
 
-	_fechaIngreso_, de tipo LocalDate, consultable,derivada, a partir de la fecha y hora de ingreso.
-	_horaIngereso_, de tipo String, consultable,derivada, a partir de la fecha y hora de ingreso.


### Factoría
Descripción breve de la factoría.

- _método static of_: Recibe nombre, apellidos, dni, fecha de nacimiento, código y fecha y hora de ingreso y devuelve un objeto paciente.
-	_método static of: Recibe un objeto persona, un código y una fecha y hora de ingreso y devuelve un objeto paciente. 

### Tipo PacienteEstudio


**Propiedades**:

- _id_, de tipo String, consultable. 
- _genero_, de tipo String, consultable.
- _edad_, de tipo Double, consultable.
- _hipertension_, de tipo Boolean, consultable.
- _enfermedadCorazon_, de tipo Boolean, consultable.
- _tipoResidencia_, de tipo TipoResidencia, consultable.
- _nivelMedioGlucosa_, de tipo Double, consultable.


**Restricciones**:
 
- R1: La edad tiene que ser mayor o igual que cero y menor o igual que 130.
- R2: El nivel medio de glucosa tiene que ser mayor o igual que cero.

**Representación como cadena**: Por defecto asociado al record.

**Criterio de igualdad**: Por defecto asociado al record. 

**Criterio de ordenación**: Según la edad y el id.

### Factoría
Descripción breve de la factoría.

- _método static of_:  Recibe valores para cada propiedad básica y devuelve un objeto del tipo PacienteEstudio. 
-	_método static parse_: Recibe valores para cada propiedad básica y devuelve un objeto del tipo PacienteEstudio.  



###Interfaz
EstudioClinico

Se encarga de añadir los distintos métodos que vamos a implementar posteriormente en las clases EstudioClinicoBucles y EstudioClinicoStreams.

 Propiedades de lista :
	 Integer numeroPacientes()
	 incluyePaciente(PacienteEstudio paciente) 
	incluyePacientes(Collection<PacienteEstudio> pacientes)
	eliminaPaciente(PacienteEstudio paciente)
	 estaPaciente(PacienteEstudio paciente)
	 borraEstudio() 
 
 Método de factoría :
	EstudioClinico of(String nombreFichero)
	 List<PacienteEstudio> leeFichero(String nombreFichero)
 
 Tratamientos secuenciales:  
	 Boolean todosPacienteSonDelTipo(TipoResidencia tipo)
	 Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo)
	 Integer numeroPacientesFactorRiesgo()
	 Double edadMediaPacientesConFactorRiesgo()
	 List<PacienteEstudio> filtraPacientesPorEdad(Double edad) 
	 Map<String,List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad)
	 Map<String,Long> numeroPacientesPorGenero()
	 Map<String,Double> edadMediaPacientesPorPorGenero()


 ###EstudioClinicoBucles:
 Constructores:
 
 C1: Construye una lista de la clase PacienteEstudio vacía.
 C2: Construye una lista de objetos de la clase PacienteEstudio.
 C3: Se encarga de parsear una línea del fichero a un objeto del tipo PacienteEstudio.
  Propiedades de lista :
	 Integer numeroPacientes():Devuelve el número total de pacientes.
	 incluyePaciente(PacienteEstudio paciente) :añade un nuevo paciente a la lista.
	incluyePacientes(Collection<PacienteEstudio> pacientes): incluye en la lista una serie de pacientes que forman una colección de tipo PacienteEstudio.
	eliminaPaciente(PacienteEstudio paciente):elimina de la lista un paciente dado.
	 estaPaciente(PacienteEstudio paciente):Comprueba si hay o no un paciente en la lista.
	 borraEstudio(): elimina todos los pacientes de la lista.
 
 
 Método de factoría :
	EstudioClinico of(String nombreFichero):metodo of de EstudioClinico.
	 List<PacienteEstudio> leeFichero(String nombreFichero): Lee el fichero dado(cómo la dirección nombreFichero) y los devuelve cómo una lista.
 
 Tratamientos secuenciales:  
	 Boolean todosPacienteSonDelTipo(TipoResidencia tipo):comprueba si todos los pacientes son del tipo dado.
	 Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo): devuelve true si hay al menos  un paciente del tipo dado.
	 Integer numeroPacientesFactorRiesgo(): devuelve el número de pacientes que son factor de riesgo(true)
	 Double edadMediaPacientesConFactorRiesgo(): devuelve la edad media de aquellos pacientes que sean factor de riesgo.
	 List<PacienteEstudio> filtraPacientesPorEdad(Double edad): retorna una lista de tipo paciente estudio de aquellos pacientes sean de la edad dada.
	 Map<String,List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad): devuelve un diccionario en el que las claves son los generos y los valores los pacientes cuya edad sea mayor que la dada.
	 Map<String,Long> numeroPacientesPorGenero(): Retorna el número de paciente de cada genero.
	 Map<String,Double> edadMediaPacientesPorPorGenero():Retorna la edad media de los pacientes de cada género.
 
 
### Tipo Vacunacion

Descripción breve del tipo contenedor.

**Propiedades**:

- _Fecha_, de tipo LocalDate, consultable. 
- _comunidad_, de tipo String, consultable.
- _pfizer_, de tipo Integer, consultable.
- _moderna_, de tipo Integer, consultable.
- _astrazeneca_, de tipo Integer, consultable.
- _janssen_, de tipo Integer, consultable.
- _numeroTotal_, de tipo Integer, consultable.


**Restricciones**:
 
- R1: La fecha de debe ser posterior al 01/02/2021. 

**Representación como cadena**: Por defecto asociado al record.

**Criterio de igualdad**: Por defecto asociado al record. 

**Criterio de ordenación**: por comunidad y en caso de igualdad por fecha.

**Propiedades derivadas**
 
-	_numeroTotal_, de tipo \<Integer\>, consultable,derivada, siendo la suma de dosis de Pfizer, moderna, astrazeneca y janssen.

### Factoría
Descripción breve de la factoría.

- _método static of_:  Reecibe valores para cada propiedad básica y devuelve un objeto del tipo Vacunacion. 
-	_método static parse_: Recibe una cadena con un formato específico y devuelve un objeto del tipo Vacunacion.


### Tipo Medicamento

Descripción breve del tipo contenedor.

**Propiedades**:

- _nombreMedicamento_, de tipo String, consultable. 
- _tipoMedicamento_, de tipo TipoMedicamento, consultable.
- _codigoEnfermedad_, de tipo String, consultable.
- _farmaceutica_, de tipo String, consultable.
- _puntuacion_, de tipo Double, consultable.
- _indiceSomatico_, de tipo Integer, consultable.
- _fechaCatalogo_, de tipo LocalDate, consultable y modificable.

**Constructores**: 

- C1:recibe un parámetro por cada propiedad básica del tipo.



**Restricciones**:
 
- R1: La puntación tiene que ser mayor estricta que cero. 
- R2: El índice somático tiene que ser mayor o igual que 1000. 
- R3: La fecha de catálogo tiene que ser posterior al 01/01/2015. 

**Representación como cadena**: Según el nombre del medicamento y de la farmacéutica.

**Criterio de igualdad**: Por nombre del medicamento y farmacéutica. 

**Criterio de ordenación**:Por nombre del medicamento y en caso de igualdad por la farmacéutica.

**Propiedades derivadas**
 
-	_tratarEnfermdad_, de tipo Boolean, consultable,derivada, siendo cierta(true) si el código de la enfermedad coincide con un parámetro de tipo cadena que reciben como argumento la propiedad.


### Factoría
Descripción breve de la factoría.

-	_método static parse_: Recibe una cadena con un formato específico y devuelve un objeto de tipo Medicamento.  





