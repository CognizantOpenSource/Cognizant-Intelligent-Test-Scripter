package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{A72C217D-A1A6-46EC-8259-9BC3A7FFC4FA}")
public abstract interface IPolicyStatus
  extends Com4jObject
{
  @DISPID(2)
  @VTID(7)
  public abstract String domainName();
  
  @DISPID(3)
  @VTID(8)
  public abstract String name();
  
  @DISPID(4)
  @VTID(9)
  public abstract boolean blockPolicyUpdate();
  
  @DISPID(4)
  @VTID(10)
  public abstract void blockPolicyUpdate(boolean paramBoolean);
  
  @DISPID(5)
  @VTID(11)
  public abstract String policyUpdateBlockComment();
  
  @DISPID(5)
  @VTID(12)
  public abstract void policyUpdateBlockComment(String paramString);
  
  @DISPID(6)
  @VTID(13)
  public abstract boolean isTemplate();
  
  @DISPID(7)
  @VTID(14)
  public abstract boolean isUpToDate();
  
  @DISPID(8)
  @VTID(15)
  public abstract Date lastPropagationTime();
  
  @DISPID(9)
  @VTID(16)
  public abstract String lastPropagationReport();
  
  @DISPID(10)
  @VTID(17)
  public abstract int verificationStatus();
  
  @DISPID(11)
  @VTID(18)
  public abstract Date lastVerificationTime();
  
  @DISPID(12)
  @VTID(19)
  public abstract String lastVerificationReport();
  
  @DISPID(14)
  @VTID(20)
  public abstract IList administrators();
  
  @VTID(20)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object administrators(int paramInt);
  
  @DISPID(15)
  @VTID(21)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject linkedTemplate();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IPolicyStatus
 * JD-Core Version:    0.7.0.1
 */