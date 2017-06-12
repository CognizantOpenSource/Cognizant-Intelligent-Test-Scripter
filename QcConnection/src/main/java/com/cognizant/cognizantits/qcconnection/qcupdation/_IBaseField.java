package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{DCD217D3-9BE9-4BED-B386-1A105D84E1F0}")
public abstract interface _IBaseField
  extends Com4jObject
{
  @VTID(3)
  public abstract void _SetNeighborhood_(int paramInt1, int paramInt2);
  
  @VTID(4)
  @ReturnValue(index=0)
  public abstract String _BeforePost_(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @VTID(5)
  public abstract String _DoPost_(String paramString);
  
  @VTID(6)
  public abstract void _AfterPost_(String paramString, @MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @VTID(7)
  public abstract void _SetRequired_(String paramString, boolean paramBoolean);
  
  @VTID(8)
  public abstract boolean _GetRequired_(String paramString);
  
  @VTID(9)
  public abstract void _RestoreRequired_(String paramString);
  
  @VTID(10)
  public abstract void _SetRoot_(String paramString, @MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @VTID(11)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject _GetRoot_(String paramString);
  
  @VTID(12)
  public abstract void _RestoreRoot_(String paramString);
  
  @VTID(13)
  public abstract void _put_Field(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @VTID(14)
  public abstract boolean _VerifyPutField(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @VTID(15)
  public abstract boolean _IsFieldModified(String paramString, @Optional Object paramObject);
  
  @VTID(16)
  public abstract void _UndoField(String paramString);
  
  @VTID(17)
  public abstract boolean _VerifyPutFieldWithErrorOnFail(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @VTID(18)
  public abstract String _GetEntityOwner(IBaseField paramIBaseField);
  
  @VTID(19)
  public abstract void _VerifyRemoveItem(IBaseField paramIBaseField, String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation._IBaseField
 * JD-Core Version:    0.7.0.1
 */