package govtech.bgp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.govtech.bgp.BusinessGrantsPortal;

;
public class AcceptanceTests {
	BusinessGrantsPortal bgp;
	SoftAssert s = new SoftAssert();

	@BeforeMethod
	public void loginTest() {

		BusinessGrantsPortal.bgpLoginUntilProceed();
	}

	@Test(description = "AC1_1 Does the applicant meet the eligibility criteria - No")
	public void testAC1_1() {

		BusinessGrantsPortal.eligibilityCriteriaClickNo();
		boolean NextEnabled = BusinessGrantsPortal.isNextEnabled();
		s.assertFalse(NextEnabled, "Next Button is enabled");
		boolean EligEnabled = BusinessGrantsPortal.isEligibilityEnabled();
		s.assertFalse(EligEnabled, "Eligibility is enabled");
		boolean ContactEnabled = BusinessGrantsPortal.isContactDetailsEnabled();
		s.assertFalse(ContactEnabled, "Contact Details is enabled");
		boolean ProposalEnabled = BusinessGrantsPortal.isProposalEnabled();
		s.assertFalse(ProposalEnabled, "Proposal is enabled");
		boolean CostEnabled = BusinessGrantsPortal.isCostEnabled();
		s.assertFalse(CostEnabled, "Cost is enabled");
		boolean BusImpactEnabled = BusinessGrantsPortal
				.isBusinessImpactEnabled();
		s.assertFalse(BusImpactEnabled, "Business Impact is enabled");
		boolean DeclRevEnabled = BusinessGrantsPortal.isDeclareReviewEnabled();
		s.assertFalse(DeclRevEnabled, "Declare & Review is enabled");
		s.assertAll();

	}

	@Test(description = "AC1_2 Does the applicant meet the eligibility criteria - Yes")
	public void testAC1_2() {

		BusinessGrantsPortal.eligibilityCriteriaClickYes();
		boolean NextEnabled = BusinessGrantsPortal.isNextEnabled();
		s.assertTrue(NextEnabled, "Next Button is disabled");
		boolean EligEnabled = BusinessGrantsPortal.isEligibilityEnabled();
		s.assertTrue(EligEnabled, "Eligibility is disabled");
		boolean ContactEnabled = BusinessGrantsPortal.isContactDetailsEnabled();
		s.assertTrue(ContactEnabled, "Contact Details is disabled");
		boolean ProposalEnabled = BusinessGrantsPortal.isProposalEnabled();
		s.assertTrue(ProposalEnabled, "Proposal is disabled");
		boolean CostEnabled = BusinessGrantsPortal.isCostEnabled();
		s.assertTrue(CostEnabled, "Cost is disabled");
		boolean BusImpactEnabled = BusinessGrantsPortal
				.isBusinessImpactEnabled();
		s.assertTrue(BusImpactEnabled, "Business Impact is disabled");
		boolean DeclRevEnabled = BusinessGrantsPortal.isDeclareReviewEnabled();
		s.assertTrue(DeclRevEnabled, "Declare & Review is disabled");
		s.assertAll();
	}

	@Test(description = "AC1_3 Verify warning message")
	public void testAC1_3() {

		String msg = BusinessGrantsPortal.verifyWarningMessage();
		s.assertEquals(
				msg,
				"Visit Smart Advisor on the SME Portal for more information on other government assistance.");

	}

	@Test(description = "AC1_4 Verify SME Portal")
	public void testAC1_4() {

		String title = BusinessGrantsPortal.verifySMEPortal();
		s.assertEquals(title, "Money Matters | SME Portal");

	}

	@Test(description = "AC1_5 Verify Save function")
	public void testAC1_5() {

		BusinessGrantsPortal.verifySaveFunction();
		System.out.println("Draft Saved");
		s.assertAll();

	}

	@Test(description = "AC1_6 Verify Saved draft on Home Page")
	public void testAC1_6() {

		String ProjTitle = BusinessGrantsPortal.verifySavedDraftOnHomePage();
		s.assertEquals(ProjTitle, "Personnel lift");
		s.assertAll();

	}

	@Test(description = "AC1_7 Verify Saved draft on Home Page")
	public void testAC1_7() {

		String ApplRefId = BusinessGrantsPortal.submitApplicationForm();
		s.assertEquals(ApplRefId, "Application_Ref_ID");
		s.assertAll();

	}

}
