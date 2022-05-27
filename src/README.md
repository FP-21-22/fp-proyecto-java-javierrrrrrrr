# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2021/2022)
Autor/a: \<Javier Nieto Vicioso\  uvus:\javnievic@us.es\




## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.clinico**: Paquete que contiene las clases "Paciente","PacienteEstudio" y "Persona" y un enumerado "TipoResidencia" del proyecto.
  * **fp.clinico.test**: Paquete que contiene las clases de test del proyecto del paquete fp.clinico.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto.
  * **fp.utiles**: Paquete que contiene las clases de utilidad. 
  *  **fp.famaceutico**:  Paquete que contiene las clases "Medicamento" y el enumerado "TipoEnumerado" del proyecto.
  *  **fp.farmaceutico.test**: Paquete que contiene las clases de test del proyecto del paquete fp.famaceutico.
  *  **fp.vacunas**: Paquete que contiene la clase Vacunacion.
  *  **fp.vacunas.test**: Paquete que contiene las clases de test del proyecto del paquete fp.vacunas.


* **/data**: Contiene el dataset o datasets del proyecto
    * **\<ccaa_vacunas_3.csv\>**: Dataset de las distintas vacunas.
    * **\<estudio_clinico.csv\>**: Dataset del estudio clínico.
    * **\<medicamentos.csv\>**: Dataset de una serie de medicamentos.
    
## Estructura del *dataset*
## ccaa_vacunas_3.csv


El dataset está compuesto por 1788 columnas, con la siguiente descripción:

* **Fecha_publicación**: de tipo LocalDate, representa la fecha de la vacuna
* **CCAA**: de tipo String, representa la comunidad autónoma.
* **Pfizer**: de tipo Integer, representa el nº de vacunas pfizer.
* **Moderna**: de tipo Integer,representa el nº de vacunas Moderna.
* **Astrazeneca**: de tipo Integer,representa el nº de vacunas Astrazeneca.
* **Janssen**: de tipo Integerrepresenta el nº de vacunas ed Janssen.


## estudio_clinico.csv

El dataset está compuesto por 18601 columnas, con la siguiente descripción:

* **id** : de tipo String, representa el id del paciente
* **edad** : de tipo Double, representa la edad del paciente.
* **hipertensión** : de tipo boolean, representa si tiene o no hipertensión.
* **enfermedadCorazon** : de tipo boolean, representa si tiene enfermedad en el corazón.
*  **tipoResidencia** : de tipo TipoResidencia, representa el tipo de residencia.
*   **nivelMedioGlucosa** : de tipo Double,  representa el nivel medio de la glucosa.
*
## medicamentos.csv
El dataset está compuesto por 21 columnas, con la siguiente descripción:
* **Nombre_medicamento** : de tipo String, representa el nombre del medicamento.
* **Tipo_medicamento** : de tipo TipoMedicamento, representa el tipo del medicamento
* * **Codigo_enfermedad** : de tipo String, representa el código de la enfermedad.
* * **Farmaceutica** : de tipo String, representa la farmaceutica .
* * **Puntuacion** : de tipo Double, representa la puntuacion del medicamento.
* * **IndiceSomatico** : de tipo Integer, representa el índice somático
* * * **Fecha_catalogo** : de tipo LocalDate, representa la la fecha de catálogo.
* 
## Tipos implementados

En este proyecto he usado 5 tipos los 4 primeros(Paciente, PacienteEstudio,Persona,Vacunacion),han sido implementados con un record, ya que sus propiedades son inmutables, y la útima(Medicamento), que es una clase, con sus getters y setters.

### Tipo Persona
Clase que describe objetos de tipo Persona,nombre,apellidos,dni,fecha de nacimiento y la edad de la persona.

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


- _método static of_: recibe nombre, apellidos, dni y fecha de nacimiento y devuelve un objeto persona.
-	_método static parse_: Recibe una cadena con un formato específico y devuelve un objeto  persona.



### Tipo Paciente
Clase que describe objetos de tipo Paciente, cada uno con las propiedades:persona, el código de ingreso, la fecha y la hora a la que ingresóm la fecha de ingreso ,así como la hora de su ingreso.

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


- _método static of_: Recibe nombre, apellidos, dni, fecha de nacimiento, código y fecha y hora de ingreso y devuelve un objeto paciente.
-	_método static of: Recibe un objeto persona, un código y una fecha y hora de ingreso y devuelve un objeto paciente. 

### Tipo PacienteEstudio
Clase que describe objetos de tipo PacienteEstudio, cada uno con las propiedades: id, el género de la persona,su edad,la hipertensión, si tiene o no una enfermedad del corazon, su tipo de residencia, el nivel medio de glucosa, y si es factor de riesgo.

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


- _método static of_:  Recibe valores para cada propiedad básica y devuelve un objeto del tipo PacienteEstudio. 
-	_método static parse_: Recibe valores para cada propiedad básica y devuelve un objeto del tipo PacienteEstudio.  

### Factoría EstudioClinicoBucles
Se encarga de leer el csv "estudio_clinico.csv" y le aplica los siguientes métodos:

EstudioClinico of(String nombreFichero)
 List<PacienteEstudio> leeFichero(String nombreFichero)
 Boolean todosPacienteSonDelTipo(TipoResidencia tipo)
 Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo)
 Integer numeroPacientesFactorRiesgo()
 Double edadMediaPacientesConFactorRiesgo()
 List<PacienteEstudio> filtraPacientesPorEdad(Double edad)
 Map<String,List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) 
 Map<String,Long> numeroPacientesPorGenero()
 Map<String,Double> edadMediaPacientesPorPorGenero()

### Factoría EstudioClinicoStreams
 Se encarga de leer el csv "estudio_clinico.csv" y le aplica los mismos métodos que en EstudioClinicoBucles pero haciendo uso de los streams:

### Tipo Vacunacion
Clase que describe objetos de tipo Vacunacion, cada uno con las propiedades:la fecha de vacunación, la comunidad, la cantidad de vacunados con pfizer, moderna, astrazenenca, janssen, el número de personas y el número total de vacunados.

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


- _método static of_:  Reecibe valores para cada propiedad básica y devuelve un objeto del tipo Vacunacion. 
-	_método static parse_: Recibe una cadena con un formato específico y devuelve un objeto del tipo Vacunacion.


### Tipo Medicamento

Clase que describe objetos de tipo Medicamento, cada uno con las propiedades: el nombre del medicamento, el tipo ed medicamneto que es, el código de la enfermedad,la farmaceútica,la puntuación, el índice somático, la fecha de catálogo y si se puede o no tratar la enfermedad.

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


-	_método static parse_: Recibe una cadena con un formato específico y devuelve un objeto de tipo Medicamento.  


### ListadoMedicamentos
Clase que se encarga de leer el csv "medicamentos.csv" y le aplica los siguientes métodos:
• existeMedicamentoSegunTipoAnteriorA: dado un tipo de medicamento y una fecha, 
indica si existe un medicamento de dicho tipo posterior a la fecha dada. 
• nombreMedicamentosPuntuacionMayorA: dada una puntuación, devuelve un 
conjunto con los nombres de los medicamentos con una puntuación mayor a la dada.
• nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento: dado un tipo 
de medicamento, devuelve el nombre del medicamento con mayor índice somático. 
En caso de no haber ninguno, se eleva una excepción. 
• agrupaTipoMedicamentoSegunPuntuacionMedia: devuelve un diccionario que 
asocia a cada tipo de medicamento su puntuación media. 
• fechaCatalogoMasFrecuente: devuelve la fecha del catálogo más frecuente, es decir, 
la que aparece más veces.

### Vacunaciones
Clase que se encarga de leer el csv "ccaa_vacunas_3.csv" y le aplica los siguientes métodos:
• anyadeVacunacion: dado un objeto del tipo Vacunacion lo añade al atributo de 
List<Vacunacion>. 
10 
FUNDAMENTOS DE PROGRAMACIÓN Curso: 2021/22 
PROYECTO DE LABORATORIO – JAVA – Subgrupo IS2-3 Versión: 3.0.0 
• vacunacionesEntreFechas: dadas dos fechas como parámetros de entrada, devuelve 
una lista con aquellas vacunaciones entre dichas fechas. 
• existeNumPersonasPautaCompletaPorEncimaDe: dada una comunidad y un valor 
entero, indica si existen o no vacunaciones con un número de personas con la pauta 
completa de vacunación por encima del valor entero dado. 
• diaMasVacunacionesEn: dada una comunidad, devuelve la fecha en la que hubo más 
personas vacunadas. 
• vacunacionesPorFecha: devuelve un mapa, o diccionario, en el que las claves son las 
fechas y los valores son listas de vacunaciones asociadas a dichas fechas. 
• maximoNumTotalVacunasporComunidad: devuelve un mapa, o diccionario, en el 
que las claves son las comunidades y los valores son el máximo para el número total 
de vacunas puestas para cada comunidad.

