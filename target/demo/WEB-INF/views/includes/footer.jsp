<%--
  Created by IntelliJ IDEA.
  User: kimyeongung
  Date: 20/02/2020
  Time: 9:04 오후
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
<!-- Core Scripts - Include with every page -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>


<!-- Page-Level Plugin Scripts - Tables -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- SB Admin Scripts - Include with every page -->
<script src="${pageContext.request.contextPath}/resources/js/sb-admin.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
</script>

</body>

</html>
