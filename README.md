# Trabajo Práctico N° 1: Patrones de Diseño 

**Universidad Nacional de Villa Mercedes (UNViMe)**  
**Materia:** Ingeniería de Software  
**Grupo:** Cahe Emilio, Carballo Emilio, García Nicolás, Mercado Luka, Moneo Martina, Oliva Jonathan, Rimada Lisandro, Sibona Franco, Silvera Álvaro.

## 📌 Objetivo del Proyecto
El objetivo de este proyecto es analizar, comprender e implementar mediante código fuente los principales Patrones de Diseño orientados a objetos. Se busca demostrar cómo estos patrones resuelven problemas recurrentes de arquitectura de software, mejorando la modularidad, escalabilidad y el mantenimiento del código sin violar principios de diseño sólidos.

## 🧩 Patrones Implementados

El repositorio contiene ejemplos prácticos divididos en tres categorías fundamentales:

### Patrones Creacionales
Se enfocan en los mecanismos de creación de objetos.
*   **Builder:** Patrón que nos permite construir objetos complejos paso a paso. Separa el código de construcción de la lógica de negocio.
*   **Prototype:** Patrón que nos permite copiar objetos existentes sin que el código dependa de sus clases.

### Patrones Estructurales
*   **Adapter:** Permite la colaboración entre objetos con interfaces incompatibles. Separa la lógica de traducción de la lógica de negocio.
*   **Decorator:** Permite comprimir y encriptar información sensible, independientemente del código que utilice esos datos. Suma comportamientos a un objeto sin tener que crear subclases nuevas.
*   **Facade:** Proporciona una interfaz simplificada a una biblioteca, un framework o cualquier otro grupo complejo de clases. 

### Patrones de Comportamiento
*   **Chain of Responsibility:** Permite pasar solicitudes a lo largo de una cadena de manejadores. Cada clase se encarga de realizar una única tarea sobre la solicitud.
*   **Memento:** Permite guardar y restaurar el estado previo de un objeto sin revelar los detalles de su implementación.
*   **Observer:** Permite definir un mecanismo de suscripción para notificar a varios objetos sobre cualquier evento que les suceda al objeto que están observando.
*   **State:** Permite a un objeto alterar su comportamiento cuando su estado interno cambia. Sustituye extensas cadenas de switch o if-else dependientes del estado por polimorfismo limpio.
*   **Strategy:** Permite definir una familia de algoritmos, colocar cada uno en una clase separada y hacer que sus objetos sean intercambiables. 

## 🚀 Instrucciones de Ejecución

El código fuente de este proyecto está desarrollado en **Java**. Para ejecutar los ejemplos de implementación de cada patrón, sigue estos pasos:

1. **Clonar el repositorio:**
   git clone https://github.com/LisandroNR/Patrones-IngSoftware.git
   
2. **Abrir el proyecto:**
   Abre la carpeta raíz del repositorio en un entorno de desarrollo compatible con Java.
   
3. **Ejecutar los patrones:**
   Cada patrón de diseño se encuentra encapsulado en su propia subcarpeta. 
   * Navega hasta la carpeta del patrón que deseas probar.
   * Abre el archivo principal que contiene la clase ejecutora.
   * Ejecuta el archivo para visualizar la salida en la terminal.