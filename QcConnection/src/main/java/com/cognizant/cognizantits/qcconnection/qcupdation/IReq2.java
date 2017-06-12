package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{35692E1B-C235-426A-A77B-CD0D159C4F2E}")
public abstract interface IReq2
  extends IReq
{
  @DISPID(37)
  @VTID(54)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject reqTraceFactory(int paramInt);
  
  @DISPID(38)
  @VTID(55)
  public abstract boolean hasReqTraceability(int paramInt);
  
  @DISPID(39)
  @VTID(56)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject requirementType();
  
  @DISPID(40)
  @VTID(57)
  public abstract String typeId();
  
  @DISPID(40)
  @VTID(58)
  public abstract void typeId(String paramString);
  
  @DISPID(41)
  @VTID(59)
  public abstract IStream get_Icon();
  
  @DISPID(42)
  @VTID(60)
  public abstract int parentId();
  
  @DISPID(42)
  @VTID(61)
  public abstract void parentId(int paramInt);
  
  @DISPID(43)
  @VTID(62)
  public abstract void populateTargetCycleToChildren();
  
  @DISPID(44)
  @VTID(63)
  public abstract void populateTargetReleaseToChildren();
  
  @DISPID(45)
  @VTID(64)
  public abstract boolean hasRichContent();
  
  @DISPID(46)
  @VTID(65)
  public abstract IList getCoverageTestsByReqFilter(String paramString, @Optional @DefaultValue("0") boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReq2
 * JD-Core Version:    0.7.0.1
 */