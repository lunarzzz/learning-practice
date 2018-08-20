<!-- Javascript goes in the document HEAD -->
<script type="text/javascript">
    function altRows(id){
        if(document.getElementsByTagName){

            var table = document.getElementById(id);
            var rows = table.getElementsByTagName("tr");

            for(i = 0; i < rows.length; i++){
                if(i % 2 == 0){
                    rows[i].className = "evenrowcolor";
                }else{
                    rows[i].className = "oddrowcolor";
                }
            }
        }
    }
    window.onload=function(){
        altRows('alternatecolor');
    }
</script>

<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
    table.altrowstable {
        font-family: verdana,arial,sans-serif;
        font-size:11px;
        color:#333333;
        border-width: 1px;
        border-color: #a9c6c9;
        border-collapse: collapse;
    }
    table.altrowstable th {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #a9c6c9;
    }
    table.altrowstable td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #a9c6c9;
    }
    .oddrowcolor{
        background-color:#d4e3e5;
    }
    .evenrowcolor{
        background-color:#c3dde0;
    }
</style>

<!-- Table goes in the document BODY -->
<table class="altrowstable" id="alternatecolor">
    <tr>
        <th colspan="2">价格统计</th>
    </tr>
    <tr>
        <#list header as head>
            <th>${head}</th>
        </#list>

    </tr>

        <#list userList as user>
        <tr>
            <td>${user.name!}</td>
            123123
            <td>${user.age!}</td>
        </tr>
        </#list>

    <div>
        ${helloWorld}
    </div>

</table>
