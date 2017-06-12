package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{45FF281C-B518-494A-A720-392B36BD7729}")
public abstract interface IComparisonSettings
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String type();
  
  @DISPID(2)
  @VTID(8)
  public abstract IList fields();
  
  @VTID(8)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object fields(int paramInt);
  
  @DISPID(3)
  @VTID(9)
  public abstract boolean attachments();
  
  @DISPID(4)
  @VTID(10)
  public abstract boolean richContent();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComparisonSettings
 * JD-Core Version:    0.7.0.1
 */