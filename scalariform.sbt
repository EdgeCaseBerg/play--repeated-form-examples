import scalariform.formatter.preferences._

// Preferences for scalariform
scalariformPreferences := scalariformPreferences.value
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(PreserveDanglingCloseParenthesis, true)
  .setPreference(AlignParameters, false)
  .setPreference(IndentWithTabs, true)
  .setPreference(MultilineScaladocCommentsStartOnFirstLine, true)