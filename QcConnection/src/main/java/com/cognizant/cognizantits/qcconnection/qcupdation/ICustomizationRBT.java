package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{ACAEB7E2-FD86-4A8C-957E-A934FB730219}")
public abstract interface ICustomizationRBT
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList biQuestions();
  
  @VTID(7)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object biQuestions(int paramInt);
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject biQuestionByID(int paramInt);
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addBIQuestion();
  
  @DISPID(4)
  @VTID(10)
  public abstract void deleteBIQuestion(int paramInt);
  
  @DISPID(11)
  @VTID(11)
  public abstract IList fpQuestions();
  
  @VTID(11)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object fpQuestions(int paramInt);
  
  @DISPID(12)
  @VTID(12)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject fpQuestionByID(int paramInt);
  
  @DISPID(13)
  @VTID(13)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addFPQuestion();
  
  @DISPID(14)
  @VTID(14)
  public abstract void deleteFPQuestion(int paramInt);
  
  @DISPID(20)
  @VTID(15)
  public abstract int testingPolicyMatrix(int paramInt1, int paramInt2);
  
  @DISPID(20)
  @VTID(16)
  public abstract void testingPolicyMatrix(int paramInt1, int paramInt2, int paramInt3);
  
  @DISPID(21)
  @VTID(17)
  public abstract int testingLevelPercentage(int paramInt);
  
  @DISPID(21)
  @VTID(18)
  public abstract void testingLevelPercentage(int paramInt1, int paramInt2);
  
  @DISPID(22)
  @VTID(19)
  public abstract int fpLevelTestingEffortInHours(int paramInt);
  
  @DISPID(22)
  @VTID(20)
  public abstract void fpLevelTestingEffortInHours(int paramInt1, int paramInt2);
  
  @DISPID(23)
  @VTID(21)
  public abstract int biLevelRiskLowerThreshold(int paramInt);
  
  @DISPID(23)
  @VTID(22)
  public abstract void biLevelRiskLowerThreshold(int paramInt1, int paramInt2);
  
  @DISPID(24)
  @VTID(23)
  public abstract int fpLevelRiskLowerThreshold(int paramInt);
  
  @DISPID(24)
  @VTID(24)
  public abstract void fpLevelRiskLowerThreshold(int paramInt1, int paramInt2);
  
  @DISPID(25)
  @VTID(25)
  public abstract String displayedTimeUnits();
  
  @DISPID(25)
  @VTID(26)
  public abstract void displayedTimeUnits(String paramString);
  
  @DISPID(30)
  @VTID(27)
  public abstract boolean updated();
  
  @DISPID(40)
  @VTID(28)
  public abstract String translateFPLevel(int paramInt);
  
  @DISPID(41)
  @VTID(29)
  public abstract String translateBILevel(int paramInt);
  
  @DISPID(42)
  @VTID(30)
  public abstract String translateTestingLevel(int paramInt);
  
  @DISPID(50)
  @VTID(31)
  public abstract int calcBILevelByAnswersWeight(int paramInt);
  
  @DISPID(51)
  @VTID(32)
  public abstract int calcFPLevelByAnswersWeight(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationRBT
 * JD-Core Version:    0.7.0.1
 */