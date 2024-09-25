VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
END
Attribute VB_Name = "FolderPathDialog"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Option Explicit

' ダイアログボックスのタイトル
Private title_ As String

Public Function GetFolderPath(ByRef folder_path As String) As Boolean
  GetFolderPath = False
  
  With Application.FileDialog(msoFileDialogFolderPicker)
    .Title = title_
    
    If .Show = 0 Then
      MsgBox "フォルダの選択をキャンセルしました。"
      Exit Function
    End If
    
    folder_path = .SelectedItems(1)
  End With
  
  GetFolderPath = True
End Function

Public Property Let Title(ByVal dialog_title As String)
  title_ = dialog_title
End Property
