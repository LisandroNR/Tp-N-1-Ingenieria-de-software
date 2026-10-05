# Trabajo Práctico Nº 1: Patrones de Diseño

## 🎯 Objetivo del Proyecto
El propósito de este proyecto es implementar, analizar y documentar tres patrones de diseño de software fundamentales (**Singleton**, **Observer** y **Strategy**) utilizando Java. Se busca aplicar principios de programación orientada a objetos (POO), desacoplamiento, extensibilidad y modularidad en la arquitectura del código fuente.

---

## 🏗️ Patrones Implementados

El repositorio se organiza en módulos independientes para cada patrón:

### 1. Patrón Singleton (Creacional)
* **Propósito:** Garantizar que una clase tenga una única instancia en toda la aplicación y proporcionar un punto de acceso global a ella.
* **Ubicación:** Carpeta `Singleton/`.
* **Punto de Entrada:** `MainSingleton.java`.

### 2. Patrón Observer (Comportamiento)
* **Propósito:** Definir una relación de dependencia uno a muchos entre objetos, permitiendo que cuando un objeto central (*Sujeto/Editor*) cambie de estado o ejecute una acción, todos sus dependientes (*Observadores/Listeners*) sean notificados automáticamente sin generar acoplamiento fuerte.
* **Ubicación:** Carpeta `Observer/`.
* **Estructura implementada:**
  * `Editor`: Clase generadora de eventos (abrir y guardar archivos).
  * `EventManager`: Administrador que gestiona las suscripciones, cancelaciones y notificaciones de eventos.
  * `EventListeners`: Interfaz que define el método de actualización (`update(filename)`).
  * `EmailAlertsListener`: Observador concreto para alertas por correo electrónico.
  * `LoggingListener`: Observador concreto para registrar eventos en bitácoras/logs.
* **Punto de Entrada:** `MainObserver.java`.

### 3. Patrón Strategy (Comportamiento)
* **Propósito:** Definir una familia de algoritmos, encapsular cada uno de ellos y hacerlos intercambiables en tiempo de ejecución, permitiendo variar el comportamiento de un objeto independientemente de los clientes que lo utilicen.
* **Ubicación:** Carpeta `Strategy/`.
* **Estructura implementada:**
`Strategy (Interfaz)`: Define el contrato común (`algorithm()`) que deben cumplir todas las estrategias concretas.
`ConcreteStrategyA`, `ConcreteStrategyB`, `ConcreteStrategyC` (Clases Concretas): Implementan la interfaz aportando distintas variantes del algoritmo.
`Context` (Clase de Contexto): Contiene una referencia a `Strategy` (composición) y permite modificarla mediante `setStrategy()` o ejecutarla mediante `executeStrategy()`
* **Punto de Entrada:** `MainStrategy.java`.

### 4. Patrón Decorator (Estructural)
* **Propósito:** Permitir añadir funcionalidades de manera dinámica a un objeto envolviéndolo en clases contenedoras (decoradores) que comparten la misma interfaz, ofreciendo una alternativa flexible a la herencia para extender comportamientos.
* **Ubicación:** Carpeta `Decorator/`.
* **Estructura implementada:**
`DataSource` (Interfaz): Define el contrato estándar para leer y escribir datos.

`FileDataSource` (Componente Concreto): Implementación básica encargada de operar directamente sobre el archivo.

`DataSourceDecorator` (Decorador Base): Clase que implementa la interfaz y mantiene una referencia interna (`wrappee`) al objeto envuelto.

`EncryptionDecorator` y `CompressionDecorator` (Decoradores Concretos): Extienden el decorador base para aplicar capas adicionales de seguridad (encriptación) o optimización (compresión) en tiempo de ejecución.
* **Punto de Entrada:** `MainDecorator.java`.

### 5. Patrón Facade (Estructural)
* **Propósito:** Proporcionar una interfaz unificada y simplificada a un conjunto de interfaces de un subsistema complejo, facilitando su uso por parte del cliente y reduciendo el acoplamiento general del sistema.
* **Ubicación:** Carpeta `Facade/`.
* **Estructura implementada:**
`Facade` (Clase Fachada Principal): Coordina y agrupa las llamadas a las distintas clases del subsistema a través de un método unificado (subsystemOperation()).

`AdditionalFacade` (Fachada Adicional): Ofrece operaciones complementarias para evitar sobrecargar la fachada principal con funciones no relacionadas.

`SubsystemOne`, `SubsystemTwo`, `SubsystemThree` (Clases del Subsistema): Conjunto de clases internas que realizan el trabajo real de forma independiente.

`MainFacade` (Cliente): Interactúa únicamente con la fachada, desconociendo la complejidad de las clases internas del subsistema.
* **Punto de Entrada:** `MainFacade.java`.

### 6. Patrón Chain of Responsibility (Comportamiento)
* **Propósito:** Permitir que una solicitud pase a través de una cadena de objetos receptores hasta que uno de ellos la procese, desacoplando al emisor del receptor y permitiendo flexibilidad para que la petición escale automáticamente.
* **Ubicación:** Carpeta `ChainOfResponsibility/`.
* **Estructura implementada:**
`ComponentWithContextualHelp` (Interfaz Manejador): Declara el contrato común (`showHelp()`) para procesar las solicitudes de ayuda.

`Component` (Manejador Base): Implementa la interfaz y mantiene una referencia al siguiente eslabón (`container`), encargándose de delegar la solicitud si el componente actual no puede resolverla.

`Container` (Clase Contenedor): Extiende del componente base y agrupa una colección de elementos hijos.

`Button`, `Panel`, `Dialog` (Manejadores Concretos): Clases finales que evalúan si poseen recursos propios de ayuda o si deben propagar el evento hacia arriba en la cadena.

* **Punto de Entrada:** `MainCHOR.java`.


### 7.  Patrón Memento (Comportamiento)
* **Propósito:** Permitir capturar y externalizar el estado interno de un objeto sin violar su encapsulamiento, de manera que el objeto pueda ser restaurado posteriormente a dicho estado (soporte para operaciones de Undo/Redo).

* **Ubicación:** Carpeta Memento/.

* **Estructura  implementada:** 

TextEditor (Originator): Posee el estado real (content, cursorPosition). Es el único responsable de empaquetar su estado en un memento (save()) y de restaurarse a partir de él (restore()).

TextEditorMemento (Memento): Objeto inmutable que almacena la instantánea del estado. Funciona como una caja negra hacia el exterior.

History (Caretaker): Administra la pila de instantáneas pasadas. Almacena y provee los mementos según se requiera, sin examinar ni manipular su contenido interno.

* **Punto de Entrada:** MainMemento.java.

### 8. Patrón State (Comportamiento)
* **Propósito:** Permitir que un objeto altere su comportamiento cuando cambia su estado interno, dando la apariencia de haber cambiado de clase al eliminar sentencias condicionales masivas (if/switch) y encapsular los comportamientos específicos en clases de estado independientes.

* **Ubicación:** Carpeta State/.

* **Estructura implementada:**

Player (Contexto): Mantiene la referencia al estado actual y le delega la ejecución de las acciones (clickPlay(), clickLock(), clickNext()). Permite realizar transiciones mediante changeState().

State (Clase Abstracta / Interfaz): Define el contrato para todas las operaciones sensibles al estado (onPlay(), onLock(), onNext()) y mantiene una referencia al contexto Player.

ReadyState, PlayingState, LockedState (Estados Concretos): Implementan las reacciones particulares a cada evento y controlan las transiciones dinámicas entre los distintos modos del reproductor.

* **Punto de Entrada:** MainState.java.

## 🚀 Instrucciones de Ejecución

Asegúrate de tener instalado **Java JDK** (versión 8 o superior) en tu entorno.

### Clonar el repositorio
```bash
git clone <https://github.com/LisandroNR/Tp-N-1-Ingenieria-de-software.git>
cd Tp-N-1-Ingenieria-de-software

Ejecución del Patrón Observer/Strategy/Singleton/Decorator/Facade
Para compilar y ejecutar el ejemplo del patrón Observer/Strategy/Singleton/Decorator/Facade/ChainOfResponsibility:

Ingresar al directorio del patrón
cd Observer/Strategy/Singleton/Decorator/Facade/ChainOfResponsibility

Compilar los archivos Java:
javac *.java

Ejecutar la clase principal
java MainObserver/MainStrategy/MainSingleton/MainDecorator/MainFacade/MainCHOR

