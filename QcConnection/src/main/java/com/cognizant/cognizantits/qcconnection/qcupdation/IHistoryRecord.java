package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{BCAE2958-39FA-4742-93B4-16D204CF67AB}")
public abstract interface IHistoryRecord
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String fieldName();
  
  @DISPID(2)
  @VTID(8)
  public abstract Date changeDate();
  
  @DISPID(3)
  @VTID(9)
  public abstract String changer();
  
  @DISPID(4)
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object newValue();
  
  @DISPID(5)
  @VTID(11)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object itemKey();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IHistoryRecord
 * JD-Core Version:    0.7.0.1
 */