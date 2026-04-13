# Anotacion
## Definicion
- Una anotación en Java es una forma de agregar información o instrucciones al código, sin cambiar directamente la lógica.

- Una anotación es una etiqueta que le dice a Java o a un framework (como Spring): “Haz algo especial con esta clase, método o variable”

## Utilidad
- Las anotaciones permiten:

1. Configurar comportamiento
2. Reducir código (evitan configuraciones largas)
3. Automatizar tareas


❌ Sin anotaciones (antes)
Mucho XML y configuración manual
✅ Con anotaciones
@Service
public class MiServicio {}


Son etiquetas inteligentes que le dicen al framework como Spring :
“esto es un servicio”
“esto es un endpoint”
“esto se guarda en la base de datos”