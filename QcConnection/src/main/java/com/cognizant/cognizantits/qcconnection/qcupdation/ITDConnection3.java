package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.GUID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{D5630429-4097-45C3-B581-2A01C6999DDD}")
public abstract interface ITDConnection3
  extends ITDConnection2
{
  @DISPID(88)
  @VTID(97)
  public abstract String getNonce(int paramInt);
  
  @DISPID(89)
  @VTID(98)
  public abstract void validate(int paramInt, String paramString);
  
  @DISPID(90)
  @VTID(99)
  public abstract IList getExtensions(int paramInt);
  
  @DISPID(91)
  @VTID(100)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject extensionFactory(GUID paramGUID);
  
  @DISPID(92)
  @VTID(101)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject extensionsManager();
  
  @DISPID(93)
  @VTID(102)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject releaseFactory();
  
  @DISPID(94)
  @VTID(103)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject cycleFactory();
  
  @DISPID(95)
  @VTID(104)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject releaseFolderFactory();
  
  @DISPID(96)
  @VTID(105)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject serviceFactory();
  
  @DISPID(97)
  @VTID(106)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject serviceFolderFactory();
  
  @DISPID(98)
  @VTID(107)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject serviceGroupFactory();
  
  @DISPID(99)
  @VTID(108)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject serviceChangeFactory();
  
  @DISPID(100)
  @VTID(109)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject applicationEntityTreeManager();
  
  @DISPID(101)
  @VTID(110)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject applicationEntityFactory();
  
  @DISPID(102)
  @VTID(111)
  public abstract IList getTDParamsNames();
  
  @VTID(111)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object getTDParamsNames(int paramInt);
  
  @DISPID(103)
  @VTID(112)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject changeEntityTreeManager();
  
  @DISPID(104)
  @VTID(113)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject changeEntityFactory();
  
  @DISPID(105)
  @VTID(114)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject applicationConfigurationFactory();
  
  @DISPID(106)
  @VTID(115)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject blueprintFactory();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDConnection3
 * JD-Core Version:    0.7.0.1
 */