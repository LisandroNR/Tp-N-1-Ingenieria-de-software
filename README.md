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

## 🚀 Instrucciones de Ejecución

Asegúrate de tener instalado **Java JDK** (versión 8 o superior) en tu entorno.

### Clonar el repositorio
```bash
git clone <https://github.com/LisandroNR/Tp-N-1-Ingenieria-de-software.git>
cd Tp-N-1-Ingenieria-de-software

Ejecución del Patrón Observer/Strategy/Singleton
Para compilar y ejecutar el ejemplo del patrón Observer/Strategy/Singleton:

Ingresar al directorio del patrón
cd Observer/Strategy/Singleton

Compilar los archivos Java:
javac *.java

Ejecutar la clase principal
java MainObserver/MainStrategy/MainSingleton