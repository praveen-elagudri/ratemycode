let editor = CodeMirror(document.getElementById("codeeditor"),{
    value: "#test {\n\tposition: absolute;\n\twidth: auto;\n\theight: 50px;\n}",
    tabSize: 5,
    lineNumbers: true,
    firstLineNumber: 1,
    extraKeys: {"Ctrl-Space": "autocomplete"},
    matchBrackets: true,
    mode: "text/x-java",
    cursorScrollMargin:50
});