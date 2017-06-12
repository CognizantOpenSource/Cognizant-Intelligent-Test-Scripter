package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{4E3DA2DC-070F-4E73-BE64-2E91A8CA7DF8}")
public abstract interface ITDConnection2
  extends ITDConnection
{
  @DISPID(75)
  @VTID(84)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject productInfo();
  
  @DISPID(76)
  @VTID(85)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject graphBuilder();
  
  @DISPID(77)
  @VTID(86)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject auditRecordFactory();
  
  @DISPID(78)
  @VTID(87)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject auditPropertyFactory();
  
  @DISPID(79)
  @VTID(88)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject tsTestFactory();
  
  @DISPID(80)
  @VTID(89)
  public abstract boolean isSearchSupported();
  
  @DISPID(81)
  @VTID(90)
  public abstract void login(String paramString1, String paramString2);
  
  @DISPID(82)
  @VTID(91)
  public abstract void connect(String paramString1, String paramString2);
  
  @DISPID(83)
  @VTID(92)
  public abstract void disconnect();
  
  @DISPID(84)
  @VTID(93)
  public abstract void logout();
  
  @DISPID(85)
  @VTID(94)
  public abstract boolean loggedIn();
  
  @DISPID(86)
  @VTID(95)
  public abstract IList visibleDomains();
  
  @VTID(95)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object visibleDomains(int paramInt);
  
  @DISPID(87)
  @VTID(96)
  public abstract IList visibleProjects(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDConnection2
 * JD-Core Version:    0.7.0.1
 */