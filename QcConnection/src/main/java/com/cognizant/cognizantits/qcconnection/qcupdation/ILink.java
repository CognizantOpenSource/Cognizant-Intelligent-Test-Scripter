package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{79CFC0C1-7BB6-48CE-BC47-8074DDBCA542}")
public abstract interface ILink
  extends IBaseField
{
  @DISPID(11)
  @VTID(20)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject sourceEntity();
  
  @DISPID(12)
  @VTID(21)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject targetEntity();
  
  @DISPID(12)
  @VTID(22)
  public abstract void targetEntity(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(13)
  @VTID(23)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject linkedByEntity();
  
  @DISPID(14)
  @VTID(24)
  public abstract String createdBy();
  
  @DISPID(14)
  @VTID(25)
  public abstract void createdBy(String paramString);
  
  @DISPID(15)
  @VTID(26)
  public abstract Date creationDate();
  
  @DISPID(15)
  @VTID(27)
  public abstract void creationDate(Date paramDate);
  
  @DISPID(16)
  @VTID(28)
  public abstract String linkType();
  
  @DISPID(16)
  @VTID(29)
  public abstract void linkType(String paramString);
  
  @DISPID(17)
  @VTID(30)
  public abstract String comment();
  
  @DISPID(17)
  @VTID(31)
  public abstract void comment(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILink
 * JD-Core Version:    0.7.0.1
 */