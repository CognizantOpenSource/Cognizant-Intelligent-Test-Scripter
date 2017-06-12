package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{5BBB5891-F832-497C-BE92-76A242809E67}")
public abstract interface ITestSet
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  public abstract String name();
  
  @DISPID(14)
  @VTID(24)
  public abstract void name(String paramString);
  
  @DISPID(15)
  @VTID(25)
  public abstract String status();
  
  @DISPID(15)
  @VTID(26)
  public abstract void status(String paramString);
  
  @DISPID(16)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject tsTestFactory();
  
  @DISPID(17)
  @VTID(28)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject conditionFactory();
  
  @DISPID(18)
  @VTID(29)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildSummaryGraph(@Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("0") int paramInt, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(19)
  @VTID(30)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildProgressGraph(@Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("0") int paramInt1, @Optional @DefaultValue("1") int paramInt2, @Optional @DefaultValue("0") int paramInt3, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(20)
  @VTID(31)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject startExecution(String paramString);
  
  @DISPID(21)
  @VTID(32)
  public abstract void purgeExecutions();
  
  @DISPID(22)
  @VTID(33)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject execEventNotifyByMailSettings();
  
  @DISPID(23)
  @VTID(34)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject executionSettings();
  
  @DISPID(24)
  @VTID(35)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject testDefaultExecutionSettings();
  
  @DISPID(25)
  @VTID(36)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildTrendGraph(@Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("0") int paramInt, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(26)
  @VTID(37)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildPerfGraph(@Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("0") int paramInt, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean1, @Optional @DefaultValue("0") boolean paramBoolean2);
  
  @DISPID(27)
  @VTID(38)
  public abstract void resetTestSet(boolean paramBoolean);
  
  @DISPID(28)
  @VTID(39)
  public abstract String checkTestInstances(String paramString);
  
  @DISPID(29)
  @VTID(40)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject buildProgressGraphEx(@Optional @DefaultValue("") String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("-1") boolean paramBoolean1, @Optional @DefaultValue("0") int paramInt1, @Optional @DefaultValue("1") int paramInt2, @Optional @DefaultValue("0") int paramInt3, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2, @Optional @DefaultValue("0") boolean paramBoolean2, @Optional @DefaultValue("0") boolean paramBoolean3);
  
  @DISPID(30)
  @VTID(41)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject testSetFolder();
  
  @DISPID(30)
  @VTID(42)
  public abstract void testSetFolder(@MarshalAs(NativeType.VARIANT) Object paramObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITestSet
 * JD-Core Version:    0.7.0.1
 */