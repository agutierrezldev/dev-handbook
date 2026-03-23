## Bloques fundamentales

### Componentes
Un componente es la unidad básica de la interfaz de usuario en Angular. 
Representa una parte de la UI, desde un botón hasta una página completa.

Un componente está compuesto por:

- **Archivo TypeScript (`.ts`)**: contiene la lógica del componente (estado, eventos, interacción con servicios, etc.).
- **Plantilla HTML (`.html`)**: define la estructura y el contenido visual.
- **Archivo de estilos (`.css`, `.scss`, `.sass`)** *(opcional)*: define la apariencia del componente.

> Nota: En componentes standalone, también se definen sus dependencias directamente en el decorador `@Component` mediante la propiedad `imports`.


### Rutas (Routing)
Permiten la navegación entre diferentes vistas de la aplicación sin recargar la página.
Cada ruta se asocia generalmente a un componente, que representa una vista completa (por ejemplo: home, login, dashboard).

Las rutas permiten:

- **Separación de responsabilidades**: cada vista maneja su propia lógica.
- **Control de acceso**: mediante guards (autenticación y autorización).
- **Lazy loading**: carga de módulos o componentes bajo demanda.
- **Estrategias de renderizado**: manejo de cómo y cuándo se renderizan las vistas.

> Nota: En Angular moderno, las rutas pueden cargar directamente componentes standalone usando `loadComponent`.

