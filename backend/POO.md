Polimorfismo : Es la capacidad de respetar un contrato (metodo o interfaz) y las distintas clases puedan implementar de forma distinta.
Ejemplo : 
Existe una clase Pago que tiene el metodo procesar(), las clases TarjetaCredito y Cash heredan de la clase Pago por lo tanto pueden implementar el metodo procesar() (sobreescribir el metodo) y dichas clases realizan su logica de manera diferente.

Nota: No es necerario una herencia para que vea polimorfismo , recuerda que hay polimorfismo en una implementacion de una interfaz dos clases pueden implementar una interfaz sobreescriben el metodo y la impllementacion es distinta.

Nota: Polimorfismo ocurre cuando usas una referencia del tipo padre (o interfaz)

Animal a = new Perro() (si hay)
Perro p = new Perro() (no hay)

herencia: Nos permite de una clase hija reutilizar metodos y atributos de una clase padre (establenciendo una relacion)

Nota: la herencia se puede dar de interaz a interfaz pero no de clase a interfaz

