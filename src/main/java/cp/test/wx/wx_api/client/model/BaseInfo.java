package cp.test.wx.wx_api.client.model;

import java.io.Serializable;

public class BaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7201502812082281829L;

	private String logo_url; // ��ȯ���̻� logo���ߴ�Ϊ 300*300

	/**
	 * "CODE_TYPE_TEXT"���ı� "CODE_TYPE_BARCODE"��һ ά�� "CODE_TYPE_QRCODE"���� ά�룻��
	 * ��CODE_TYPE_ONLY_QRCODE��,��ά���� code ��ʾ ��CODE_TYPE_ONLY_BARCODE��,һά���� code
	 * ��ʾ
	 */
	private String code_type; // code ��չʾ���͡�

	/**
	 * ����дֱ���ṩ������̻� �� �� �� �� �� �� �� �� �� д �� source �ֶΣ�
	 */
	private String brand_name;// �̻�����,��������Ϊ 12 ���� �֡�

	private String title; // ȯ������������Ϊ 9 �����֡�(�� �麭�ǿ�ȯ���ԡ����񼰽��)

	private String sub_title;// ȯ���ĸ����⣬��������Ϊ 18�����֡�

	private String color; // ȯ��ɫ����ɫ�ʹ淶��ע��д Color010-Color100

	/**
	 * ��һ�仰������չʾ����ҳ�� ʾ�������ʾ��ά�������ȯ��
	 */
	private String notice;// ʹ�����ѣ���������Ϊ 9 ���� �֡�

	private String service_phone;// �ͷ��绰

	private String source; // ��������Դ��������ͬ������ ������

	private String description;// ʹ��˵�������ı����������Է� �У�����Ϊ 1000 �����֡�

	private int get_limit;// ÿ�������ȡ����������дĬ�ϵ��� quantity��

	private boolean use_custom_code;// �Ƿ��Զ��� code �롣��д true �� false���������Ĭ��Ϊ
									// false
	private boolean bind_openid;// �Ƿ�ָ���û���ȡ����д true �� false���������Ĭ��Ϊ��

	private boolean can_share; // ��ȡ��ȯԭ��ҳ���Ƿ�ɷ��� ��д true �� false��true ����
								// �ɷ���Ĭ�Ͽɷ���

	private boolean can_give_friend;// ��ȯ�Ƿ��ת������д true �� false,true �����ת����Ĭ�Ͽ�
									// ת����

	// private String location_id_list;// �ŵ�λ�� ID���̻����� mp ƽ ̨��¼���ŵ���Ϣ���������
	// // �����ŵ���Ϣ�ӿڻ�ȡ�ŵ�λ �� ID��

	private DateInfo date_info;// ʹ�����ڣ���Ч�ڵ���Ϣ

	private Sku sku;// ��Ʒ��Ϣ

	private String url_name_type;
	private String custom_url;

	private String custom_url_name;

	private String custom_url_sub_title;

	private String promotion_url_name;

	private String promotion_url;

	private String promotion_url_sub_title;

	private String center_title;
	private String center_sub_title;
	private String center_url;

	public String getUrl_name_type() {
		return url_name_type;
	}

	public void setUrl_name_type(String url_name_type) {
		this.url_name_type = url_name_type;
	}

	public String getCustom_url() {
		return custom_url;
	}

	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public String getCode_type() {
		return code_type;
	}

	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSub_title() {
		return sub_title;
	}

	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getService_phone() {
		return service_phone;
	}

	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGet_limit() {
		return get_limit;
	}

	public void setGet_limit(int get_limit) {
		this.get_limit = get_limit;
	}

	public boolean isUse_custom_code() {
		return use_custom_code;
	}

	public void setUse_custom_code(boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
	}

	public boolean isBind_openid() {
		return bind_openid;
	}

	public void setBind_openid(boolean bind_openid) {
		this.bind_openid = bind_openid;
	}

	public boolean isCan_share() {
		return can_share;
	}

	public void setCan_share(boolean can_share) {
		this.can_share = can_share;
	}

	public boolean isCan_give_friend() {
		return can_give_friend;
	}

	public void setCan_give_friend(boolean can_give_friend) {
		this.can_give_friend = can_give_friend;
	}

	// public String getLocation_id_list() {
	// return location_id_list;
	// }
	//
	// public void setLocation_id_list(String location_id_list) {
	// this.location_id_list = location_id_list;
	// }

	public DateInfo getDate_info() {
		return date_info;
	}

	public void setDate_info(DateInfo date_info) {
		this.date_info = date_info;
	}

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public String getCustom_url_name() {
		return custom_url_name;
	}

	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}

	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}

	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}

	public String getPromotion_url_name() {
		return promotion_url_name;
	}

	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}

	public String getPromotion_url() {
		return promotion_url;
	}

	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}

	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}

	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}

	public String getCenter_title() {
		return center_title;
	}

	public void setCenter_title(String center_title) {
		this.center_title = center_title;
	}

	public String getCenter_sub_title() {
		return center_sub_title;
	}

	public void setCenter_sub_title(String center_sub_title) {
		this.center_sub_title = center_sub_title;
	}

	public String getCenter_url() {
		return center_url;
	}

	public void setCenter_url(String center_url) {
		this.center_url = center_url;
	}

}
// logo_url
// ��ȯ���̻� logo���ߴ�Ϊ
// 300*300��
// ��
// code_type
// code ��չʾ���͡�
// ��
// "CODE_TYPE_TEXT"���ı�
// "CODE_TYPE_BARCODE"��һ
// ά��
// "CODE_TYPE_QRCODE"����
// ά�룻��
// ��CODE_TYPE_ONLY_QRCO
// DE��,��ά���� code ��ʾ
// ��CODE_TYPE_ONLY_BARC
// ODE��,һά���� code ��ʾ
// ��
// brand_name
// �̻�����,��������Ϊ 12 ����
// �֡�����дֱ���ṩ������̻�
// �� �� �� �� �� �� �� �� �� д ��
// source �ֶΣ�
// ��
// title
// ȯ������������Ϊ 9 �����֡�(��
// �麭�ǿ�ȯ���ԡ����񼰽��)
// ��
// sub_title
// ȯ���ĸ����⣬��������Ϊ 18
// �����֡�
// ��
// color
// ȯ��ɫ����ɫ�ʹ淶��ע��д
// Color010-Color100
// ��
// notice
// ʹ�����ѣ���������Ϊ 9 ����
// �֡���һ�仰������չʾ����ҳ��
// ʾ�������ʾ��ά�������ȯ��
// ��
// service_phone
// �ͷ��绰��
// ��
// source
// ��������Դ��������ͬ�����Ρ�
// ��������
// ��
// description
// ʹ��˵�������ı����������Է�
// �У�����Ϊ 1000 �����֡�
// ��
// get_limit
// ÿ�������ȡ����������дĬ��
// ���� quantity��
// ��
// use_custom_code
// �Ƿ��Զ��� code �롣��д true
// �� false���������Ĭ��Ϊ
// false��
// ��
// bind_openid
// �Ƿ�ָ���û���ȡ����д true
// �� false���������Ĭ��Ϊ��
// ��
// can_share
// ��ȡ��ȯԭ��ҳ���Ƿ�ɷ���
// ��д true �� false��true ����
// �ɷ���Ĭ�Ͽɷ���
// ��
// 9
// can_give_friend
// ��ȯ�Ƿ��ת������д true ��
// false,true �����ת����Ĭ�Ͽ�
// ת����
// ��
// location_id_list
// �ŵ�λ�� ID���̻����� mp ƽ
// ̨��¼���ŵ���Ϣ���������
// �����ŵ���Ϣ�ӿڻ�ȡ�ŵ�λ
// �� ID��
// ��
// date_info
// ʹ�����ڣ���Ч�ڵ���Ϣ
// ��
// type
// ʹ��ʱ�������
// ��
// 1���̶��������䣬2���̶�ʱ
// ��������ȡ�����㣩
// ��
// begin_timesta
// mp
// �̶���������ר�ã���ʾ����ʱ
// �� �� �� 1970 �� 1 �� 1 ��
// 00:00:00 ������ʱ���������
// ������ת��Ϊ�ַ�����̬���룬
// ��ͬ������λΪ�룩
// ��
// end_timestamp
// �̶���������ר�ã���ʾ����ʱ
// �䡣����λΪ�룩
// ��
// fixed_term
// �̶�ʱ��ר�ã���ʾ����ȡ���
// ��������Ч������λΪ�죩
// ��
// fixed_begin_ter
// m
// �̶�ʱ��ר�ã���ʾ����ȡ���
// ���쿪ʼ��Ч������λΪ�죩
// ��
// sku
// ��Ʒ��Ϣ��
// ��
// quantity
// �ϼܵ�����������֧����д 0
// �����޴�
// ��
// url_name_type
// �̻��Զ��� cell ����
// ��
// 10
// ������
// URL_NAME_TYPE_TAKE_AW
// AY
// ����Ԥ����
// URL_NAME_TYPE_RESERVA
// TION
// ����ʹ��
// URL_NAME_TYPE_USE_IMM
// EDIATELY
// ����ԤԼ
// URL_NAME_TYPE_APPOINT
// MENT
// ���߶һ�
// URL_NAME_TYPE_EXCHAN
// GE
// ��Ա����
// URL_NAME_TYPE_VIP_SERVI
// CE
// ��Ա����
// URL_NAME_TYPE_VIP_PRIVI
// LEGE
// ���ද̬
// URL_NAME_TYPE_FLIGHT_D
// YNAMIC
// ���� custom_url �ֶι�ͬʹ
// �ã�
// ��
// custom_url
// �̻��Զ��� url ��ַ��֧�ֿ�ȯ
// ҳ����ת,��תҳ������������
// ���� cell ���Ʊ���һ�¡�
// ��
// promotion_url_na
// me_type
// ����Ȩ���Զ��� cell
// ��
// 11
// ����һ��
// URL_NAME_TYPE_BUY_GRO
// UPON_AGAIN
// ����
// URL_NAME_TYPE_PURCHAS
// E
// �ٴι���
// URL_NAME_TYPE_PURCHAS
// E_AGAIN
// ��Ȩ���赥����ͨ����
// promotion_url �ֶι�ͬʹ�ã�
// promotion_url
// ����Ȩ���Զ��� url ��ַ��֧��
// ��ȯҳ����ת,��תҳ��������
// �� cell ���Ʊ���һ�¡���Ȩ��
// �赥����ͨ��