package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{2AF970F7-6CCC-4DFB-AA78-08F689481F94}")
public abstract interface IBug
  extends IBaseFieldExMail
{
  @DISPID(15)
  @VTID(24)
  public abstract String status();
  
  @DISPID(15)
  @VTID(25)
  public abstract void status(String paramString);
  
  @DISPID(16)
  @VTID(26)
  public abstract String project();
  
  @DISPID(16)
  @VTID(27)
  public abstract void project(String paramString);
  
  @DISPID(17)
  @VTID(28)
  public abstract String summary();
  
  @DISPID(17)
  @VTID(29)
  public abstract void summary(String paramString);
  
  @DISPID(18)
  @VTID(30)
  public abstract String priority();
  
  @DISPID(18)
  @VTID(31)
  public abstract void priority(String paramString);
  
  @DISPID(19)
  @VTID(32)
  public abstract String detectedBy();
  
  @DISPID(19)
  @VTID(33)
  public abstract void detectedBy(String paramString);
  
  @DISPID(20)
  @VTID(34)
  public abstract String assignedTo();
  
  @DISPID(20)
  @VTID(35)
  public abstract void assignedTo(String paramString);
  
  @DISPID(21)
  @VTID(36)
  public abstract IList findSimilarBugs(@Optional @DefaultValue("10") int paramInt);
  
  @DISPID(22)
  @VTID(37)
  public abstract boolean hasChange();
  
  @DISPID(23)
  @VTID(38)
  public abstract IList changeLinks();
  
  @VTID(38)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object changeLinks(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBug
 * JD-Core Version:    0.7.0.1
 */