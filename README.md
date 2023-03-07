# integration-open-shift


> Essas aplicações foram desenvolvidas para ser gerenciadas pelo openShift 4.1.12 
> 
> Criando o banco de dados postgre conforme configurações da aplicação.
> 
> ![image](https://user-images.githubusercontent.com/28515964/223291692-4a3f40fd-03ff-4ead-a02b-eac4d2d7d897.png) ![image](https://user-images.githubusercontent.com/28515964/223291905-8efb2eb8-7e0e-4b65-a2d5-5c21f9d9fbfb.png) Entrando no pod do banco e criando a base de dados ![image](https://user-images.githubusercontent.com/28515964/223291953-05377f04-706a-4647-aabd-429f72493923.png) Banco ok ![image](https://user-images.githubusercontent.com/28515964/223292003-5ddee9a2-550d-43ab-8632-4b6f0c2e064e.png) Adicionando projeto java-spring-boot no openShift, apartir do repositório git ![image](https://user-images.githubusercontent.com/28515964/223292044-4d13c488-fd72-4210-8595-f06994d2721b.png) https://github.com/tjca1/integration-open-shift.git Build Ok ![image](https://user-images.githubusercontent.com/28515964/223292086-0287e68e-8c8a-4a5e-8528-ed4a81471874.png) Adicionando secrets para autenticação no banco ![image](https://user-images.githubusercontent.com/28515964/223292115-23ce1510-c032-4096-825c-460ec7608334.png) ![image](https://user-images.githubusercontent.com/28515964/223292159-d4d63a1b-9b51-44b8-a33b-d3ca08af1a15.png) Adicionando Environment url do banco de dados que já esta com o serviço ‘openshiftdb’ escultando no openShift ![image](https://user-images.githubusercontent.com/28515964/223292209-cab69667-a9ec-4906-b74e-28665bb86afc.png) Uma ilustração do vinculo de informação, desenvolvida local X openShift ![image](https://user-images.githubusercontent.com/28515964/223292249-02081451-37a2-44ae-9df8-6548f39b4511.png) Configuração local das variáveis ![image](https://user-images.githubusercontent.com/28515964/223292292-7d75cfb2-c788-4fa7-a876-7c933c15c96d.png) Agora vamos testar as apis, em Routes -> conseguimos copiar a url do pod ![image](https://user-images.githubusercontent.com/28515964/223292350-850e4bcc-fb59-40cb-a20b-84b25bca2419.png) Antes de testar vamos adicionar um autoscaler na aplicação para melhor desempenho ![image](https://user-images.githubusercontent.com/28515964/223292415-18846d8e-4bd6-4d88-b512-59e796249fe7.png) Autoscaler criado, assim que o cpu do pod ultrapassar 50% é acionado ![image](https://user-images.githubusercontent.com/28515964/223292472-328d2a0a-c97b-4b7c-8306-2799a26f93aa.png) Aplicação rodando. ![image](https://user-images.githubusercontent.com/28515964/223292513-e19904dc-ca1d-4407-92c2-0505938cf36b.png) Teste: ![image](https://user-images.githubusercontent.com/28515964/223292557-025cd908-4f42-487a-acd5-85c8c710d706.png) ![image](https://user-images.githubusercontent.com/28515964/223292575-8576d3f5-67f3-49b9-9b41-a7bff42d164d.png) ![image](https://user-images.githubusercontent.com/28515964/223292590-f646bd2c-8214-4aac-9455-4c650f491f31.png) Classe service onde imprimiu o log no openshift ![image](https://user-images.githubusercontent.com/28515964/223292620-bc35802b-2817-45c9-9e33-5255e1b583c5.png) 
![image](https://user-images.githubusercontent.com/28515964/223296706-418cffc8-39d7-4a18-9104-ef39d303a1b0.png)


# Rascunho terminal instalação CRC
> Instalação opeShifit CRC: _2 versoes do openShift sudo reboot 
> (_**)Primeira é o openShift da redHat onde vc precisa de uma subScription https://developers.redhat.com 
> click em 'join Red Hat Develop' https://console.redhat.com sudo wget https://developers.redhat.com/content-gateway/rest/mirror/pub/openshift- v4/clients/crc/latest/crc-linux-amd64.tar.xz pullsecret {**} 
> tar -xf crc-linux-amd64.tar.xz sudo mv crc-linux-2.14.0-amd64/crc /usr/local/bin cd /usr/local/bin https://github.com/crc-org/crc/wiki/VPN-support--with-an--userland-network-stack 
> Run crc delete, 
> crc cleanup and remove 
> the folder $HOME/.crc Remove eventual _.crc.testing 
> records in your hosts file /etc/hosts. crc setup Start the virtual machine as usual systemctl stop docker.service crc start 
> /****_****problemas com daimon****_/ crc cleanup sudo rmmod vmw_vsock_vmci_transport sudo modprobe vhost_vsock crc setup crc start 
> /********************error: You must be logged in to the server (Unauthorized)****_********/ 
> crc config set cpus 4 crc config set memory 9000 sudo chmod 666 /etc/hosts crc setup crc start -c 4 -m 9000 https://console-openshift-console.apps-crc.testing /*************************************/ 
> The server is accessible via web console at: https://console-openshift-console.apps-crc.testing 
> Log in as 
> administrator: Username: kubeadmin Password: *_****-hak2S-****_-BjAAN Log in as user: 
> Username: developer Password: developer Use the 'oc' command line interface: 
> $ eval $(crc oc-env) 
> $ oc login -u developer https://api.crc.testing:6443 
> find ~/.crc/ -name kubeconfig /home/root2/.crc/cache/crc_libvirt_4.12.1_amd64 
> export KUBECONFIG=/home/root2/.crc/machines/crc/kubeconfig crc console --credentials /////


