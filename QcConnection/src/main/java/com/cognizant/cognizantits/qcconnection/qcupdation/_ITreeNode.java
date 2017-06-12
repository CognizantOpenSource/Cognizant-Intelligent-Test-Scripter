package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.VTID;

@IID("{81113FC0-ECB4-43E5-AEF6-BFEEC9560CB4}")
public abstract interface _ITreeNode
  extends Com4jObject
{
  @VTID(3)
  public abstract int _GetFatherID_();
  
  @VTID(4)
  public abstract ISysTreeNode _FindChildNode_(String paramString, boolean paramBoolean);
  
  @VTID(5)
  public abstract boolean _IsInitialized_();
  
  @VTID(6)
  public abstract void _SetNodeData_(String paramString);
  
  @VTID(7)
  public abstract void _MoveChild(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject, boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation._ITreeNode
 * JD-Core Version:    0.7.0.1
 */