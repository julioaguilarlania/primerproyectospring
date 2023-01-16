<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    <title>Captura de Vehículo</title>
    </head>
    <body>
        <c:if test="${error != null}">
            <div class="error"> ${error} </div>
        </c:if>
        <form action="guardar">
        <div>
        <label>Placas:</label>
        <input type="text" name="placas" value="${vehiculo.placas}"/>
        </div>
        <div>
        <label>Marca:</label>
        <input type="text" name="marca"/>
        </div>
        <div>
        <label>Modelo:</label>
        <input type="text" name="modelo"/>
        </div>
        <div>
        <label>Color:</label>
        <input type="text" name="color"/>
        </div>
        <div>
        <label>Kilometraje:</label>
        <input type="text" name="kilometraje"/>
        </div>
        <div>
        <button type="submit">Guardar</button>
        </div>
        </form>
    </body>
</html>