VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
END
Attribute VB_Name = "FileNameLoader"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Option Explicit

' 事前バインディング
' Microsoft Scripting Runtime

' 親フォルダ
Private parentPath_ As String

' ファイル拡張子
Private extension_ As String

Public Sub LoadFileNames(ByRef file_names As Dictionary)
  Set file_names = New Dictionary
  
  If parentPath_ = "" Then
    Debug.Print "FileNameLoader.LoadFileNames" & vbCrLf & "parentPath_ = """""
    Exit Sub
  End If
  
  If Dir(parentPath_, vbDirectory) = "" Then
    Debug.Print "FileNameLoader.LoadFileNames folder not found" & vbCrLf & """" & parentPath_ & """"
    Exit Sub
  End If
  
  Dim file_name As String
  file_name = Dir(parentPath_ & "\*" & extension_)
  
  Do Until file_name = ""
    Dim file_path As String
    file_path = parentPath_ & "\" & file_name
    
    If Not file_path = ThisWorkbook.FullName Then
      file_names.Add file_name, file_path
    End If
    
    file_name = Dir()
  Loop
End Sub

Public Property Let ParentPath(ByVal parent_path As String)
  parentPath_ = parent_path
End Property

Public Property Let Extension(ByVal file_extension As String)
  If Not file_extension = "" Then
    extension_ = "." & file_extension
  End If
  
  extension_ = file_extension
End Property
