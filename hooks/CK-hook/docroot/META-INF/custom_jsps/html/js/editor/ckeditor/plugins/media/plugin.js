(function() {

var STR_DIV = 'div';

CKEDITOR.plugins.add(
	'media',
	{
		TPL_SCRIPT_PREFIX_USE: 'AUI().use(' +
								'"aui-base", "aui-{dialog}",',

		TPL_SCRIPT_PREFIX_FUNCTION: 'function(A) {',

		TPL_SCRIPT_PREFIX_LOGIC: 'var mediaId = A.guid();' +
								'var mediaDivNode = A.one(".ck{dialog}-no-id");' +
								'mediaDivNode.attr("id", mediaId);' +
								'mediaDivNode.removeClass("ck{dialog}-no-id");',

		TPL_SCRIPT_PREFIX_CONFIG: 'var mediaConfig = {',

		TPL_SCRIPT_SUFFIX_CONFIG: '};',

		TPL_SCRIPT_SUFFIX_RENDER: 'new A.{mediaAUI}(mediaConfig).render();',

		TPL_SCRIPT_SUFFIX_END: '}' +
								');',

		afterInit: function(editor) {
			var dataProcessor = editor.dataProcessor;

			var	dataFilter = dataProcessor && dataProcessor.dataFilter;
			var	htmlFilter = dataProcessor && dataProcessor.htmlFilter;

			if (dataFilter) {
				dataFilter.addRules(
					{
						elements: {
							'div': function(realElement) {
								var attributeClass = realElement.attributes['class'];

								var fakeElement;

								var mediaPlugin = editor.plugins.media;

								var audio = mediaPlugin.hasClass(attributeClass, 'liferayckeaudio');
								//var video = mediaPlugin.hasClass(attributeClass, 'liferayckevideo');

								if (audio) {
									var realChild = realElement.children && realElement.children[0];

									if (realChild &&
										(mediaPlugin.hasClass(realChild.attributes['class'], 'ckaudio-no-id')) &&
										realChild.children && realChild.children.length) {

										realChild.children[0].value = '';
									}

									var cssClass = 'liferay_cke_audio';
									var element = 'audio';

									fakeElement = editor.createFakeParserElement(realElement, cssClass, element, false);
								}

								return fakeElement;
							}
						}
					}
				);
			}
			if (htmlFilter) {
				htmlFilter.addRules(
					{
						elements: {
							'div': function(realElement) {
								var attributeClass = realElement.attributes['class'];

								var mediaPlugin = editor.plugins.media;

								if ((mediaPlugin.hasClass(attributeClass, 'ckaudio-no-id')) &&
									realElement.children && realElement.children.length) {

									realElement.children[0].value = '';
								}

								return realElement;
							}
						}
					}
				);
			}
		},

		applyMediaScript: function(mediaNode, dialog, configText) {
			var instance = this;

			var dialogReplace = { dialog:dialog	};

			var mediaAUI = 'Audio';

			var scriptUse = new CKEDITOR.template(instance.TPL_SCRIPT_PREFIX_USE);

			var textScriptUse = scriptUse.output(dialogReplace);

			var scriptLogic = new CKEDITOR.template(instance.TPL_SCRIPT_PREFIX_LOGIC);

			var textScriptLogic = scriptLogic.output(dialogReplace);

			var scriptRender = new CKEDITOR.template(instance.TPL_SCRIPT_SUFFIX_RENDER);

			var textScriptRender = scriptRender.output(
					{
						mediaAUI:  mediaAUI
					}
			);

			instance.replaceScriptContent(mediaNode, textScriptUse + instance.TPL_SCRIPT_PREFIX_FUNCTION + textScriptLogic + instance.TPL_SCRIPT_PREFIX_CONFIG + configText + instance.TPL_SCRIPT_SUFFIX_CONFIG + textScriptRender + instance.TPL_SCRIPT_SUFFIX_END);
		},

		getPlaceholderCss: function() {
			var instance = this;

			return 'img.liferay_cke_audio {' +
				'background: #CCC url(' + CKEDITOR.getUrl(instance.path + 'icons/placeholder_audio.png') + ') no-repeat 50% 50%;' +
				'border: 1px solid #A9A9A9;' +
				'display: block;' +
				'height: 30px;' +
				'width: 100%;' +
			'}';
		},

		init: function(editor) {
			var instance = this;

			CKEDITOR.dialog.add('audio', instance.path + 'dialogs/audio.js');

			editor.addCommand('Audio', new CKEDITOR.dialogCommand('audio'));

			editor.ui.addButton(
				'Audio',
				{
					command: 'Audio',
					icon: instance.path + 'icons/icon_audio.png',
					label: Liferay.Language.get('audio')
				}
			);

			if (editor.addMenuItems) {
				editor.addMenuItems(
					{
						audio: {
							command: 'Audio',
							group: 'flash',
							label: Liferay.Language.get('edit-audio')
						}
					}
				);
			}

			editor.on(
				'doubleclick',
				function(event) {
					var element = event.data.element;

					var type;

					if (instance.isElementType(element, 'audio')) {
						type = 'audio';
					}

					if (type) {
						event.data.dialog = type;
					}
				}
			);

			if (editor.contextMenu) {
				editor.contextMenu.addListener(
					function(element, selection) {
						var value = {};

						if (!element.isReadOnly()) {
							var type;

							if (instance.isElementType(element, 'audio')) {
								type = 'audio';
							}

							if (type) {
								value[type] = CKEDITOR.TRISTATE_OFF;
							}
						}

						return value;
					}
				);
			}

			editor.lang.fakeobjects.audio = Liferay.Language.get('audio');
		},

		isElementType: function(el, type) {
			var instance = this;

			return (el && el.is('img') && el.data('cke-real-element-type') === type);
		},

		createDivStructure: function(editor, containerClass, boundingBoxClass) {
			var divNode = editor.document.createElement(STR_DIV);

			divNode.setAttribute('class', containerClass);

			var boundingBoxTmp = editor.document.createElement(STR_DIV);

			boundingBoxTmp.setAttribute('class', boundingBoxClass);

			var scriptTmp = editor.document.createElement('script');

			scriptTmp.setAttribute('type', 'text/javascript');

			divNode.append(boundingBoxTmp);
			divNode.append(scriptTmp);

			return divNode;
		},

		hasClass: function(attributeClass, target) {
			return (attributeClass && attributeClass.indexOf(target) != -1);
		},

		replaceScriptContent: function(divNode, scriptContent) {
			if (divNode.getChildCount() == 2) {
				var scriptTmp = null;

				divNode.getChild(1).remove();

				AUI().use(
					'aui-node',
					function(A) {
						var scriptNode = A.Node.create('<script type="text/javascript">' + scriptContent + '</script>');

						scriptTmp = new CKEDITOR.dom.element(scriptNode.getDOM());

						divNode.append(scriptTmp);
					}
				);
			}
		},

		restoreElement: function(editor, instance, fakeImage, type) {
			var content = null;

			if (fakeImage && fakeImage.data('cke-real-element-type') && fakeImage.data('cke-real-element-type') === type) {
				instance.fakeImage = fakeImage;

				content = editor.restoreRealElement(fakeImage);
			}

			instance.setupContent(content);
		},

		onLoad: function() {
			var instance = this;

			if (CKEDITOR.addCss) {
				CKEDITOR.addCss(instance.getPlaceholderCss());
			}
		},

		onOkCallback: function(callerInstance, editor, dialog) {
			var instance = this;

			var extraStyles = {};

			var containerCss = 'liferayckeaudio audio-container';
			var nonProcessedClass = 'ckaudio-no-id';

			var divNode = instance.createDivStructure(editor, containerCss, nonProcessedClass);

			callerInstance.commitContent(divNode);

			var fakeClass = 'liferay_cke_audio';

			var newFakeImage = editor.createFakeElement(divNode, fakeClass, dialog, false);

			if (callerInstance.fakeImage) {
				newFakeImage.replace(callerInstance.fakeImage);

				editor.getSelection().selectElement(newFakeImage);
			}
			else {
				editor.insertElement(newFakeImage);
			}
		},

		onShowCallback: function(instance, editor, dialog) {
			instance.fakeImage = null;

			var fakeImage = instance.getSelectedElement();

			this.restoreElement(editor, instance, fakeImage, dialog);
		}
	}
);

})();