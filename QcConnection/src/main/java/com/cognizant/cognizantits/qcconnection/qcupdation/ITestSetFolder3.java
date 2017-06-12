package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{42A0D93D-2E7A-4D93-A9DF-754928F7F6BC}")
public abstract interface ITestSetFolder3
  extends ITestSetFolder2
{
  @DISPID(28)
  @VTID(38)
  public abstract void targetCycle(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(28)
  @VTID(39)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object targetCycle();
  
  @DISPID(29)
  @VTID(40)
  public abstract IList folderFields();
  
  @VTID(40)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object folderFields(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITestSetFolder3
 * JD-Core Version:    0.7.0.1
 */