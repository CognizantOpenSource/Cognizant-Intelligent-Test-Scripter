package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{51A0C1D6-F748-41D1-988F-B0B93013F1BC}")
public abstract interface IBPParam
  extends IBaseField
{
  @DISPID(20)
  @VTID(20)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject reference();
  
  @DISPID(20)
  @VTID(21)
  public abstract void reference(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(21)
  @VTID(22)
  public abstract int type();
  
  @DISPID(22)
  @VTID(23)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject componentParam();
  
  @DISPID(23)
  @VTID(24)
  public abstract String componentParamName();
  
  @DISPID(26)
  @VTID(25)
  public abstract int componentParamIsOut();
  
  @DISPID(24)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject bpComponent();
  
  @DISPID(25)
  @VTID(27)
  public abstract int componentParamOrder();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBPParam
 * JD-Core Version:    0.7.0.1
 */