package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{74B94507-8A42-4D11-B5BD-943B76C9A982}")
public abstract interface IChange
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  public abstract String description();
  
  @DISPID(14)
  @VTID(24)
  public abstract void description(String paramString);
  
  @DISPID(15)
  @VTID(25)
  public abstract String comments();
  
  @DISPID(15)
  @VTID(26)
  public abstract void comments(String paramString);
  
  @DISPID(16)
  @VTID(27)
  public abstract String createdBy();
  
  @DISPID(17)
  @VTID(28)
  public abstract Date creationDate();
  
  @DISPID(18)
  @VTID(29)
  public abstract Date closingDate();
  
  @DISPID(18)
  @VTID(30)
  public abstract void closingDate(Date paramDate);
  
  @DISPID(19)
  @VTID(31)
  public abstract String voB_Labels();
  
  @DISPID(19)
  @VTID(32)
  public abstract void voB_Labels(String paramString);
  
  @DISPID(20)
  @VTID(33)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject changeEntryFactory();
  
  @DISPID(21)
  @VTID(34)
  public abstract void addBugLink(int paramInt);
  
  @DISPID(22)
  @VTID(35)
  public abstract void removeBugLink(int paramInt);
  
  @DISPID(23)
  @VTID(36)
  public abstract IList getBugLinks();
  
  @VTID(36)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object getBugLinks(int paramInt);
  
  @DISPID(24)
  @VTID(37)
  public abstract boolean autoGetLinks();
  
  @DISPID(24)
  @VTID(38)
  public abstract void autoGetLinks(boolean paramBoolean);
  
  @DISPID(25)
  @VTID(39)
  public abstract String links();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IChange
 * JD-Core Version:    0.7.0.1
 */