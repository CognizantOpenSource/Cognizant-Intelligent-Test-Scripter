package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{B08CEC57-0E62-49BB-9791-0D764F613B2E}")
public abstract interface IRelease
  extends IBaseFieldExMail
{
  @DISPID(15)
  @VTID(24)
  public abstract String name();
  
  @DISPID(15)
  @VTID(25)
  public abstract void name(String paramString);
  
  @DISPID(16)
  @VTID(26)
  public abstract Date startDate();
  
  @DISPID(16)
  @VTID(27)
  public abstract void startDate(Date paramDate);
  
  @DISPID(17)
  @VTID(28)
  public abstract Date endDate();
  
  @DISPID(17)
  @VTID(29)
  public abstract void endDate(Date paramDate);
  
  @DISPID(18)
  @VTID(30)
  public abstract String status();
  
  @DISPID(18)
  @VTID(31)
  public abstract void status(String paramString);
  
  @DISPID(19)
  @VTID(32)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject cycleFactory();
  
  @DISPID(20)
  @VTID(33)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject parent();
  
  @DISPID(21)
  @VTID(34)
  public abstract int daysLeft();
  
  @DISPID(22)
  @VTID(35)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject releaseManagementInfo();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IRelease
 * JD-Core Version:    0.7.0.1
 */