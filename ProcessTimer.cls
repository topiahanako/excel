VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
END
Attribute VB_Name = "ProcessTimer"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Option Explicit

Private startTime_ As Single

Private Sub Class_Initialize()
  Debug.Print "start " & Now
  startTime_ = Timer
End Sub

Private Sub Class_Terminate()
  Debug.Print "end " & Round(Timer - startTime_, 3) & "sec"
End Sub
