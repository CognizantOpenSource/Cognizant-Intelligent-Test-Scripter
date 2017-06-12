package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{C1ED849E-CB41-45A9-A256-9A0D3CFDB350}")
public abstract interface ITestExecStatus
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int testId();
  
  @DISPID(2)
  @VTID(8)
  public abstract String message();
  
  @DISPID(3)
  @VTID(9)
  public abstract String status();
  
  @DISPID(4)
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object tsTestId();
  
  @DISPID(5)
  @VTID(11)
  public abstract int testInstance();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITestExecStatus
 * JD-Core Version:    0.7.0.1
 */