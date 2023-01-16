<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
    <title>Búsqueda de Vehículo</title>
    </head>
    <body>
        <button type="button"
            onclick="location.href='forma_nuevo'">Agregar</button>
        <form action="buscar">
        <div>
        <label>Placas:</label>
        <input type="text" name="placas"/>
        </div>
        <div>
        <button type="submit">Buscar</button>
        </div>
        </form>
    </body>
</html>