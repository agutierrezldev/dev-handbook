@Lazy
Por defecto, Spring hace inicialización eager (crea todos los beans al arrancar la app).
Con el @Lazy tu le dices a Spring que cambias la configuracion por defecto a perezosa (lazy), es decir, el bean se crea cuando se usa por primera vez.