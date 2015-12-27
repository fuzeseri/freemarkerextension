<html>

<head>
<style>
	table {
		border-collapse: collapse;
	}

	table, td, th {
		border: 1px solid black;
	}

	td {
    	padding: 5px;
		
	}
</style>
</head>

<div style="background-color: yellow;">
	<H1>${title}</H1>
</div>

<body>
	<table style="width:100%;">
		<tr>
			<#list columns as col>
				<td style="font-weight: bold; background-color: yellow;">${col.name}</td>
			</#list>
		</tr>
		<#list rows as row>
		<tr>
			<#list row.cells as cell>
				<td>${cell}</td>
			</#list>
		</tr>
		</#list>
	</table>
</body>
</html>
