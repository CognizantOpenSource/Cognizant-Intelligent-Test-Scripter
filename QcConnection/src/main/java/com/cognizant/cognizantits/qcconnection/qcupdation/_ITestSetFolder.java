package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.Holder;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.VTID;

@IID("{5FCA1AE7-AE4A-4709-BD98-13240D68BBD4}")
public abstract interface _ITestSetFolder
  extends Com4jObject
{
  @VTID(3)
  public abstract void _FindChildNode_(String paramString, boolean paramBoolean, Holder<ITestSetFolder> paramHolder, Holder<Integer> paramHolder1);
  
  @VTID(4)
  public abstract boolean _IsInitialized_();
  
  @VTID(5)
  public abstract void _SetNodeData_(String paramString);
  
  @VTID(6)
  public abstract void _MoveChild_(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject, boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation._ITestSetFolder
 * JD-Core Version:    0.7.0.1
 */