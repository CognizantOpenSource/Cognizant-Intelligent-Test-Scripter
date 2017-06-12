package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{11D45F95-7187-4311-B23D-EB36DDD19178}")
public abstract interface ISupportRBTAssessment2
  extends ISupportRBTAssessment
{
  @DISPID(17)
  @VTID(25)
  public abstract int fcChosenAnswerForQuestion(int paramInt);
  
  @DISPID(17)
  @VTID(26)
  public abstract void fcChosenAnswerForQuestion(int paramInt1, int paramInt2);
  
  @DISPID(18)
  @VTID(27)
  public abstract void assessFCLevel();
  
  @DISPID(19)
  @VTID(28)
  public abstract String assessedFCLevel();
  
  @DISPID(20)
  @VTID(29)
  public abstract boolean useCustomFCLevel();
  
  @DISPID(20)
  @VTID(30)
  public abstract void useCustomFCLevel(boolean paramBoolean);
  
  @DISPID(21)
  @VTID(31)
  public abstract String customFCLevel();
  
  @DISPID(21)
  @VTID(32)
  public abstract void customFCLevel(String paramString);
  
  @DISPID(22)
  @VTID(33)
  public abstract String effectiveFCLevel();
  
  @DISPID(23)
  @VTID(34)
  public abstract String calculatedRiskLevel();
  
  @DISPID(24)
  @VTID(35)
  public abstract boolean useCustomRiskLevel();
  
  @DISPID(24)
  @VTID(36)
  public abstract void useCustomRiskLevel(boolean paramBoolean);
  
  @DISPID(25)
  @VTID(37)
  public abstract String customRiskLevel();
  
  @DISPID(25)
  @VTID(38)
  public abstract void customRiskLevel(String paramString);
  
  @DISPID(26)
  @VTID(39)
  public abstract String effectiveRiskLevel();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISupportRBTAssessment2
 * JD-Core Version:    0.7.0.1
 */