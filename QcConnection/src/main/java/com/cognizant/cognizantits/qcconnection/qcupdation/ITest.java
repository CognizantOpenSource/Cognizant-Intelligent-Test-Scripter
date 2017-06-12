package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{4777BC00-DDBD-4DBD-ACE6-BEAE379E2051}")
public abstract interface ITest
  extends IBaseFieldExMail
{
  @DISPID(15)
  @VTID(24)
  public abstract String fullPath();
  
  @DISPID(16)
  @VTID(25)
  public abstract String type();
  
  @DISPID(16)
  @VTID(26)
  public abstract void type(String paramString);
  
  @DISPID(17)
  @VTID(27)
  public abstract String name();
  
  @DISPID(17)
  @VTID(28)
  public abstract void name(String paramString);
  
  @DISPID(18)
  @VTID(29)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject designStepFactory();
  
  @DISPID(19)
  @VTID(30)
  public abstract int desStepsNum();
  
  @DISPID(20)
  @VTID(31)
  public abstract int coverRequirement(@MarshalAs(NativeType.VARIANT) Object paramObject, int paramInt, boolean paramBoolean);
  
  @DISPID(21)
  @VTID(32)
  public abstract void removeCoverage(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(22)
  @VTID(33)
  public abstract IList getCoverList();
  
  @VTID(33)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object getCoverList(int paramInt);
  
  @DISPID(23)
  @VTID(34)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject extendedStorage();
  
  @DISPID(24)
  @VTID(35)
  public abstract String execStatus();
  
  @DISPID(25)
  @VTID(36)
  public abstract boolean hasCoverage();
  
  @DISPID(26)
  @VTID(37)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject lastRun();
  
  @DISPID(27)
  @VTID(38)
  public abstract Date execDate();
  
  @DISPID(28)
  @VTID(39)
  public abstract boolean templateTest();
  
  @DISPID(28)
  @VTID(40)
  public abstract void templateTest(boolean paramBoolean);
  
  @DISPID(29)
  @VTID(41)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject params();
  
  @DISPID(30)
  @VTID(42)
  public abstract boolean hasParam();
  
  @DISPID(31)
  @VTID(43)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject vcs();
  
  @DISPID(32)
  @VTID(44)
  public abstract String checkoutPathIfExist();
  
  @DISPID(33)
  @VTID(45)
  public abstract boolean ignoreDataHiding();
  
  @DISPID(33)
  @VTID(46)
  public abstract void ignoreDataHiding(boolean paramBoolean);
  
  @DISPID(34)
  @VTID(47)
  public abstract String fullPathEx(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITest
 * JD-Core Version:    0.7.0.1
 */